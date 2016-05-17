import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GoogleCalendar {
    /** Application name. */
    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".credentials/calendar-java-quickstart.json");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/calendar-java-quickstart.json
     */
    private static final List<String> SCOPES = Arrays.asList(CalendarScopes.CALENDAR);

    //private static String calendarId;

    private static com.google.api.services.calendar.Calendar service;

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
            //calendarId = "psl5ie1jhug7m9geanaevl6oi0@group.calendar.google.com";

            // Build a new authorized API client service.
            // Note: Do not confuse this class with the
            //   com.google.api.services.calendar.model.Calendar class.
            service = getCalendarService();
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }


    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in = GoogleCalendar.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Calendar client service.
     * @return an authorized Calendar client service
     * @throws IOException
     */
    public static com.google.api.services.calendar.Calendar getCalendarService() throws IOException {
        Credential credential = authorize();
        return new com.google.api.services.calendar.Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }





    public static List<Event> search(DateTime start, DateTime end, String calendarId) throws IOException {
        Events events = service.events().list(calendarId)
            .setTimeMin(start)
            .setTimeMax(end)
            .setTimeZone("CEST") //CSET or UTC
            .setMaxResults(2500)
            .setSingleEvents(true)
            .setOrderBy("startTime")
            .execute();
        List<Event> items = events.getItems();
        return items;
    }

    public static List<Event> searcher(String calendarId) throws IOException {
        // end X mounths after
        DateTime end = new DateTime(System.currentTimeMillis() + 604800000); //+ (2592000000L * months)
        // start 1 week before
        DateTime start = new DateTime(System.currentTimeMillis() - (2592000000L * 6)); // - 604800000

        return search(start, end, calendarId);
    }


    public static boolean equalsEvent(Event e1, Event e2){
        if(e1.getSummary().equals(e1.getSummary()) &&
        e1.getDescription().replaceAll("\n", "").replaceAll("&nbsp;","").equals(e2.getDescription().replaceAll("\n", "").replaceAll("&nbsp;","")) &&
        e1.getLocation().equals(e2.getLocation()) &&
        //e1.getSource().equals(e2.getSource()) &&
        e1.getStart().equals(e2.getStart()) &&
        e1.getEnd().equals(e2.getEnd())){
            return true;
        }
        return false;
    }

    public static Event corrispondingEvent(Event event, List<Event> calendarEvents) throws IOException{
        if (calendarEvents.size() == 0) {
            return null;
        } else {
            for (Event calendarEvent : calendarEvents) {
                // Starting the comparison
                // if the two ID are the same
                if (event.getSummary().split("_")[0].equals(calendarEvent.getSummary().split("_")[0])){
                    return calendarEvent;
                }
            }
            return null;
        }
    }

    public static void delete(Event event, String calendarId) throws IOException{
        System.out.println("Deleting an event: " + event.getId());
        service.events().delete(calendarId, event.getId()).execute();
    }

    public static boolean toUpdate(Event event, Event calendarEvent) throws IOException{
        if (calendarEvent == null || !equalsEvent(calendarEvent,event)){
            if(calendarEvent != null){
                System.out.println("Updating event...");
                // System.out.println(event.getStart());
                // System.out.println("Finish");
                // System.out.println(calendarEvent.getStart());
            }
            return true;
        }else{
            System.out.println("No need to update the event");
            return false;
        }
    }

    public static void update(List<Event> events, boolean force, String calendarId) throws IOException{
        // force : Force the update of all the events
        int i = 0;
        for (Event event : events){

            DateTime start = event.getStart().getDateTime();
            if (start == null) {
                start = event.getStart().getDate();
            }
            DateTime end = event.getEnd().getDateTime();
            if (start == null) {
                start = event.getEnd().getDate();
            }
            // Searching corrisponding events
            Event calendarEvent = corrispondingEvent(event, search (start, end, calendarId));


            if(force || toUpdate(event, calendarEvent)){
                if(calendarEvent != null){
                    delete(calendarEvent, calendarId);
                }
                write(event, calendarId);
                i++;
            }

        }

        System.out.println(i + " events updated");
    }

    public static void write(Event event, String calendarId) throws IOException{
            event = service.events().insert(calendarId, event).execute();
            System.out.printf("Event created: %s\n", event.getHtmlLink());

    }

}
