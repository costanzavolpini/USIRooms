package com.usirooms.usirooms.events;

import java.util.Comparator;

/**
 * Created by Marco on 5/29/16.
 */
public class DateTimeComparator implements Comparator<dummyEvent> {

    @Override
    public int compare(dummyEvent e1, dummyEvent e2) {
        if (e1.getStart() < e2.getStart()) {
            return -1;
        }else if (e1.getStart() > e2.getStart()){
            return 1;
        }else{
            return 0;
        }
    }
}
