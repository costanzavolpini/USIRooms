import java.util.Comparator;
import java.util.ArrayList;
import com.google.api.services.calendar.model.*;

class DateTimeComparator implements Comparator<Event> {

    @Override
    public int compare(Event e1, Event e2) {
        if (e1.getStart().getDateTime().getValue() < e2.getStart().getDateTime().getValue()) {
            return -1;
        }else{
            return 1;
        }
    }
}
