import com.google.api.services.calendar.model.*;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;


public class EventSync{

    public EventSync (final List<Event> localEvents, final List<Event> onlineEvents, final String calendarId) throws IOException{
        int i = 0;
        int j = 0;
        int updated = 0;
        int deleted = 0;
        int added = 0;
        GoogleCalendar gc = new GoogleCalendar();

        System.out.println("Starting syncronization");

        while((i < localEvents.size() - 1) && (j < onlineEvents.size())){

            if(localEvents.get(i).getStart().getDateTime().getValue() == onlineEvents.get(j).getStart().getDateTime().getValue()
            && isSameLocation(localEvents.get(i), onlineEvents.get(j)) == 0){
                // same hour and class
                if(!isEquals(localEvents.get(i), onlineEvents.get(j))){
                    // If the two events are not equals
                    gc.delete(onlineEvents.get(j), calendarId);
                    gc.write(localEvents.get(i), calendarId);

                    updated++;
                }

                if(toIncrement(localEvents.get(i).getSummary(), localEvents.get(i + 1).getSummary())){
                    i++;
                }
                i++;
                j++;
            }else if(localEvents.get(i).getStart().getDateTime().getValue() < onlineEvents.get(j).getStart().getDateTime().getValue()
            && isSameLocation(localEvents.get(i), onlineEvents.get(j)) == -1){
                // local is before
                gc.write(localEvents.get(i), calendarId);
                added++;

                if(toIncrement(localEvents.get(i).getSummary(), localEvents.get(i + 1).getSummary())){
                    i++;
                }
                i++;
            }else{
                gc.delete(onlineEvents.get(j), calendarId);
                j++;
            }

        }


        // Finish i and j

    }

    public int isSameLocation(Event e1, Event e2){
        if ((e1.getLocation().substring(0, 4).equals("Room") || (e1.getLocation().length() >= 9 && e1.getLocation().substring(5, 9).equals("Room")))
        && (e2.getLocation().substring(0, 4).equals("Room") || (e2.getLocation().length() >= 9 && e2.getLocation().substring(5, 9).equals("Room")))
        && (Integer.parseInt(e1.getLocation().substring(e1.getLocation().length() - 3, e1.getLocation().length())) == Integer.parseInt(e2.getLocation().substring(e2.getLocation().length() - 3, e2.getLocation().length())))){
            // same room
            return 0;
        }else if ((e1.getLocation().substring(0, 4).equals("Room") || (e1.getLocation().length() >= 9 && e1.getLocation().substring(5, 9).equals("Room")))
        && (e2.getLocation().substring(0, 4).equals("Room") || (e2.getLocation().length() >= 9 && e2.getLocation().substring(5, 9).equals("Room")))
        && (Integer.parseInt(e1.getLocation().substring(e1.getLocation().length() - 3, e1.getLocation().length())) < (Integer.parseInt(e2.getLocation().substring(e2.getLocation().length() - 3, e2.getLocation().length()))))){

            return -1;
        }else{
            return 1;
        }
    }

    public boolean isEquals(Event e1, Event e2){

        final boolean e1JSON = (e1.getSummary().split("[\\(\\)]").length == 2);
        final boolean e2JSON = (e2.getSummary().split("[\\(\\)]").length == 2);

        if (e1JSON != e2JSON) return false;
        if (!(e1.getSummary().equals(e2.getSummary()))) return false;
        if (e1.getEnd().getDateTime().getValue() != e2.getEnd().getDateTime().getValue()) return false;
        if (!(e1.getDescription().equals(e2.getDescription()))) return false;
        if (!(e1.getSource().getTitle().equals(e2.getSource().getTitle()))) return false;

        return true;
    }

    public boolean toIncrement(String summary1, String summary2){
        if(!(summary1.split("[\\(\\)]").length == 2 && summary2.split("[\\(\\)]").length == 1)) return false;

        return summary1.split("[\\(\\)]")[1].equals(summary2);

    }
}
