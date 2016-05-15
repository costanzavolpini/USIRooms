import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.IOException;

public class UsiEvent{

    private final String calendarId;
    private final String room;
    private List<Event> events;

    public UsiEvent(String calendarId, int months, String room) throws IOException{
        this.calendarId = calendarId;
        this.room = room;

        // end X mounths after
        DateTime end = new DateTime(System.currentTimeMillis() + 604800000); //+ (2592000000L * months)
        // start 1 week before
        DateTime start = new DateTime(System.currentTimeMillis() - (2592000000L * months)); // - 604800000

        this.events = GoogleCalendar.search(start, end, calendarId);

        changer();
        System.out.println(events.size() + " events fetched from the calendar of " + room);
    }

    public void changer(){
        for (Event event : events){
            event.setLocation(room);

            if (event.getStart().getDateTime() == null){
                EventDateTime begin = new EventDateTime()
                    .setDateTime(new DateTime(event.getStart().getDate() + "T00:00:00.000Z"))
                    .setTimeZone("Europe/Zurich");
                event.setStart(begin);

                EventDateTime end = new EventDateTime()
                    .setDateTime(new DateTime(event.getEnd().getDate() + "T23:59:59.000Z"))
                    .setTimeZone("Europe/Zurich");
                event.setEnd(end);
            }

            String[] parts = event.getSummary().split("[\\(\\)]");
            if (parts.length == 2){

                event.setSummary(parts[0]);
                Event.Source source = new Event.Source()
                .setTitle(parts[1])
                .setUrl("http://usi.ch");
                event.setSource(source);
            }
        }
    }


    public List<Event> getEvents(){
        return events;
    }
}