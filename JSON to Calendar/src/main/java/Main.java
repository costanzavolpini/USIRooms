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
import java.util.Collections;
import java.util.Comparator;

public class Main{

    private static final String calendarId = "psl5ie1jhug7m9geanaevl6oi0@group.calendar.google.com";

    public static void main(String[] args) throws IOException {

        if(false){
            // delete all
            GoogleCalendar.delete(GoogleCalendar.searcher(calendarId), calendarId);
            System.exit(0);
        }

        List<Event> listAnalize = new ArrayList<Event>();
        List<Event> events = new ArrayList<Event>();

        ArrayList<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("bachelor_inf_3_year.json");

        long startTime = System.currentTimeMillis();

        for (String jsonFile : jsonFiles){
            listAnalize = JsonAnalyzer.analyze(jsonFile);
            events.addAll(listAnalize);
        }

        System.out.println("TIME -  analysis JSONs: " + (System.currentTimeMillis() - startTime) + " ms");

        ArrayList<UsiEvent> usiEvents = new ArrayList<UsiEvent>();
        usiEvents.add(new UsiEvent("vtj0r7h12jfpjvkcagddaam3jc@group.calendar.google.com", "Room 003"));
        usiEvents.add(new UsiEvent("4uldjdn9bf00aqger105crd5bc@group.calendar.google.com", "Room 004"));
        usiEvents.add(new UsiEvent("rkm9cupl0js8rinfmrtvek9714@group.calendar.google.com", "Room 006"));
        usiEvents.add(new UsiEvent("7ms1f85tgr02ho81m7n6s28scs@group.calendar.google.com", "Room 007"));
        usiEvents.add(new UsiEvent("juuikibcrm8rqaut36bn0n6i6g@group.calendar.google.com", "Room 008"));
        usiEvents.add(new UsiEvent("8fu02csfbnnpfl7c08tg2r3ac8@group.calendar.google.com", "Room 013"));

        for (UsiEvent usiEvent : usiEvents){
            listAnalize = usiEvent.getEvents();
            events.addAll(listAnalize);
        }


        System.out.println("TIME -  total loading time: " + (System.currentTimeMillis() - startTime) + " ms");



        System.out.println("Total events loaded: " + events.size());

        Collections.sort(events, new DateTimeComparator());

        System.out.println("TIME -  all events sorted: " + (System.currentTimeMillis() - startTime) + " ms");

        List<Event> onlineEvents = GoogleCalendar.searcher(calendarId);
        System.out.println("Total online events loaded: " + onlineEvents.size());

        Collections.sort(onlineEvents, new DateTimeComparator());

        System.out.println("TIME - all loading operation finished: " + (System.currentTimeMillis() - startTime) + " ms");

        new EventSync(events, onlineEvents, calendarId);

    }

}
