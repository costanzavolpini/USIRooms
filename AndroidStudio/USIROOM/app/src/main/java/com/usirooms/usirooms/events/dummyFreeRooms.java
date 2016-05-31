package com.usirooms.usirooms.events;

/**
 * Created by Marco on 5/29/16.
 */
public class dummyFreeRooms {
    private final dummyRoom roomName;
    private long eventStart = -1000;
    private long eventEnd = -1000;


    public dummyFreeRooms(dummyRoom roomName){
        this.roomName = roomName;
    }

    public void setStart(long eventStart){
        this.eventStart = eventStart;
    }

    public void setEnd(long eventEnd){
        this.eventEnd = eventEnd;
    }

    public dummyRoom getRoom(){
        return roomName;
    }

    public long getStart(){
        return eventStart;
    }

    public long getEnd(){
        return eventEnd;
    }
}
