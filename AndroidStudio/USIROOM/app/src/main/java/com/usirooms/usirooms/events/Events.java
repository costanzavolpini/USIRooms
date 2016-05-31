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

    public ArrayList<dummyEvent> getEvents (long start, long end, String building){
        // return a list of events between start and end
        ArrayList<dummyEvent> upcomingEvents = new ArrayList<dummyEvent>();
        for (dummyEvent event : events) {
            if (building.equals(MainActivity.rooms.getRoom(event.getIdRoom()).getBuilding())){
                if ((start < event.getEnd() && event.getEnd() < end) ||
                        (start < event.getStart() && event.getStart() < end) ||
                        (start > event.getStart() && end < event.getEnd())){
                    upcomingEvents.add(event);
                }
            }
        }
        return upcomingEvents;
    }


    public ArrayList<dummyRoom> getFreeRoom (long start, long end, String building){

        ArrayList<dummyFreeRooms> freeRooms = new ArrayList<>();

        for(dummyRoom dm : MainActivity.rooms.getRoomBuilding(building)){
            // generating dummyFreeRooms
            freeRooms.add(new dummyFreeRooms(dm));
        }

        int position = binarySearch(events, 0, events.size() -1, start);

        Boolean follow = Boolean.TRUE;
        while(follow && position < events.size()){
            dummyEvent event = events.get(position);
            if(event.getStart() < start && event.getEnd() < end && event.getEnd() > start){
                //    |-----|
                //  |---|

                for (int i = 0; i < freeRooms.size(); i++){
                    dummyFreeRooms room = freeRooms.get(i);
                    if (room.getRoom().getName().equals(event.getNameRoom())){
                        room.setStart(event.getEnd());
                        i = freeRooms.size();
                    }
                }
            }else if(event.getStart() > start && event.getStart() < end){
                // |---------|
                //    |----------|
                //    |---|
                for (int i = 0; i < freeRooms.size(); i++){
                    dummyFreeRooms room = freeRooms.get(i);
                    if (room.getRoom().getName().equals(event.getNameRoom())){
                        if (room.getStart() != -1000 && (event.getStart() - room.getStart() < 960)){
                            room.setStart(event.getEnd());
                        }else {
                            room.setEnd(event.getStart());
                        }
                        i = freeRooms.size();
                    }
                }
            }else if(event.getStart() < start && event.getEnd() > end){
                for (int i = 0; i < freeRooms.size(); i++){
                    dummyFreeRooms room = freeRooms.get(i);
                    if (room.getRoom().getName().equals(event.getNameRoom())){
                        room.setStart(event.getEnd());
                        i = freeRooms.size();
                    }
                }
            }else if(event.getStart() > end){
                for (int i = 0; i < freeRooms.size(); i++){
                    dummyFreeRooms room = freeRooms.get(i);
                    if (room.getRoom().getName().equals(event.getNameRoom())){
                        if (room.getStart() != -1000){
                            room.setEnd(event.getStart());
                        }
                        i = freeRooms.size();
                    }
                }
            }
        }


        return null;
    }


    public static Integer binarySearch(ArrayList<dummyEvent> array, int lowerbound, int upperbound, long start) {
        int position;

        // To start, find the subscript of the middle position.
        position = (lowerbound + upperbound) / 2;

        while(((array.get(position).getStart() > start) || (array.get(position).getStart() < start - 36000)) && (lowerbound <= upperbound)) {
            if (array.get(position).getStart() > start) {            // If the number is > key, ..
                upperbound = position - 1;
            } else {
                lowerbound = position + 1;    // Else, increase position by one.
            }
            position = (lowerbound + upperbound) / 2;
        }
        if (lowerbound <= upperbound) {
            return position;
        } else {
            return null;
        }
    }

}

