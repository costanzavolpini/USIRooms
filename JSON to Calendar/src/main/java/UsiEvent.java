import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import java.io.IOException;

public class UsiEvent{

    private final String calendarId;
    private final String room;
    private List<Event> events;

    public UsiEvent(String calendarId, String room) throws IOException{
        this.calendarId = calendarId;
        this.room = room;
        this.events = GoogleCalendar.searcher(calendarId);

        changer();

        System.out.println(events.size() + " events fetched from the calendar of " + room);
    }

    public void changer(){

        List<Event> tempList = new ArrayList<Event>();

        Event temporaryEvent;

        for (Event event : events){

            temporaryEvent = new Event();

            String[] parts = event.getSummary().split("[\\(\\)]");
            if (parts.length == 2){
                temporaryEvent.setSummary(parts[0]);
                Event.Source source = new Event.Source()
                .setTitle(parts[1])
                .setUrl("http://usi.ch");
                temporaryEvent.setSource(source);
            }else{
                temporaryEvent.setSummary(parts[0]);
            }

            temporaryEvent.setDescription(event.getDescription());

            temporaryEvent.setLocation(room);


            if (event.getStart().getDateTime() == null){
                EventDateTime begin = new EventDateTime()
                    .setDateTime(new DateTime(event.getStart().getDate() + "T00:00:00.000Z"))
                    .setTimeZone("Europe/Zurich");
                temporaryEvent.setStart(begin);
            }else{
                temporaryEvent.setStart(event.getStart());
                if (temporaryEvent.getStart().getTimeZone() == null){
                    Date date = new Date(temporaryEvent.getStart().getDateTime().getValue());
                    DateTime datetime = new DateTime(temporaryEvent.getStart().getDateTime().getValue(), -date.getTimezoneOffset());

                    temporaryEvent.setStart(new EventDateTime().setDateTime(datetime).setTimeZone("Europe/Zurich"));
                }
            }






            if (event.getEnd().getDateTime() == null){
                EventDateTime end = new EventDateTime()
                    .setDateTime(new DateTime(event.getEnd().getDate() + "T23:59:59.000Z"))
                    .setTimeZone("Europe/Zurich");
                temporaryEvent.setEnd(end);
            }else{
                temporaryEvent.setEnd(event.getEnd());

                if (temporaryEvent.getEnd().getTimeZone() == null){
                    Date date = new Date(temporaryEvent.getEnd().getDateTime().getValue());
                    DateTime datetime = new DateTime(temporaryEvent.getEnd().getDateTime().getValue(), -date.getTimezoneOffset());

                    temporaryEvent.setEnd(new EventDateTime().setDateTime(datetime).setTimeZone("Europe/Zurich"));                }
            }

            tempList.add(temporaryEvent);
        }

        events = tempList;

    }


    public List<Event> getEvents(){
        return events;
    }
}
