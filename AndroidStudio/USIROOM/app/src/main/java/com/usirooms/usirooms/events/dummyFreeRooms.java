package com.usirooms.usirooms.events;

/**
 * Created by Marco on 5/29/16.
 */
public class dummyFreeRooms {
    private String roomName;
    private long eventStart;
    private long eventEnd;


    public void setRoom(String roomName){
        this.roomName = roomName;
    }

    public void setStart(long eventStart){
        this.eventStart = eventStart;
    }

    public void setEnd(long eventEnd){
        this.eventEnd = eventEnd;
    }

    public String getRoom(){
        return roomName;
    }

    public long getStart(){
        return eventStart;
    }

    public long getEnd(){
        return eventEnd;
    }
}
