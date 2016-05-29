package com.usirooms.usirooms.events;

import android.util.Log;

import com.usirooms.usirooms.MainActivity;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

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



            Collections.sort(events, new DateTimeComparator());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


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


    public ArrayList<dummyRoom> getFreeRoom (long date, String building){
        Rooms rooms = MainActivity.rooms;
        ArrayList<dummyRoom> freeRooms = new ArrayList<>();

        for (dummyEvent event : events){
            if (event.getEnd() > date + 1800){

            }
        }


        return null;
    }
}
