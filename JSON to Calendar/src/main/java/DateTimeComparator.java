import java.util.Comparator;
import java.util.ArrayList;
import com.google.api.services.calendar.model.*;

class DateTimeComparator implements Comparator<Event> {

    @Override
    public int compare(Event e1, Event e2) {
        if (e1.getStart().getDateTime().getValue() < e2.getStart().getDateTime().getValue()) {
            return -1;
        }else if (e1.getStart().getDateTime().getValue() > e2.getStart().getDateTime().getValue()){
            return 1;
        }else{
            if ((e1.getLocation().substring(0, 4).equals("Room") || (e1.getLocation().length() >= 9 && e1.getLocation().substring(5, 9).equals("Room")))
            && (e2.getLocation().substring(0, 4).equals("Room") || (e2.getLocation().length() >= 9 && e2.getLocation().substring(5, 9).equals("Room")))
            && (Integer.parseInt(e1.getLocation().substring(e1.getLocation().length() - 3, e1.getLocation().length())) < Integer.parseInt(e2.getLocation().substring(e2.getLocation().length() - 3, e2.getLocation().length())))){
                return -1;
            }

            return 1;
        }
    }
}
