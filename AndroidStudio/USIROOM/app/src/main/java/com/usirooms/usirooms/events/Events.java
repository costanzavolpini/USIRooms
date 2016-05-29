package com.usirooms.usirooms.events;

import android.util.Log;

import com.usirooms.usirooms.MainActivity;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Marco on 5/29/16.
 */
public class Events {
    private final ArrayList<dummyEvent> events;

    public Events(){
        JsonAnalyzer is = new JsonAnalyzer();
        events = new ArrayList<dummyEvent>();

        try {
            events.addAll(is.analyze("bachelor_inf_3_year.json"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     public class SortEventsByStart implements Comparator<Events> {
    @Override
    public int compare(dummyEvent e1, dummyEvent e2) {
    return e1.getStart().compareTo(e2.getStart());
    }
    }
     */

    public ArrayList<dummyEvent> getEvents(){
        return events;
    }

    public ArrayList<dummyEvent> getEvents (long date, String building){
        ArrayList<dummyEvent> upcomingEvents = new ArrayList<dummyEvent>();
        for (dummyEvent event : events) {
            if (building.equals(MainActivity.rooms.getRoom(event.getIdRoom()).getBuilding())){
                if (date < event.getEnd() && event.getEnd() < date + 86400000){
                    upcomingEvents.add(event);
                }
            }
        }
        return upcomingEvents;
    }


    public ArrayList<Events> getFreeRoom (int date, String building){

        return null;
    }
}
