package com.usirooms.usirooms.events;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marco on 5/29/16.
 */
public class dummyEvent {
    private long start;
    private long end;
    private String idEvent;
    private String nameEvent;
    private String description;
    private String idOrganizer;
    private String nameOrganizer;
    private String emailOrganizer;
    private String idRoom;
    private String nameRoom;


    public long StringToDateTime(String inputDate) throws ParseException {



        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");

        Date date = dateFormat.parse(inputDate);

        return new Date(date.getTime() + date.getTimezoneOffset() * 60000).getTime();
    }



    public void setStart(String start) throws ParseException {
        this.start = StringToDateTime(start);
    }

    public void setEnd(String end) throws ParseException {
        this.end = StringToDateTime(end);
    }

    public void setIdEvent(String idEvent){
        this.idEvent = idEvent;
    }

    public void setNameEvent(String nameEvent){
        this.nameEvent = nameEvent;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setIdOrganizer(String idOrganizer){
        this.idOrganizer = idOrganizer;
    }

    public void setNameOrganizer(String nameOrganizer){
        this.nameOrganizer = nameOrganizer;
    }

    public void setEmailOrganizer(String emailOrganizer){
        this.emailOrganizer = emailOrganizer;
    }

    public void setIdRoom(String idRoom){
        this.idRoom = idRoom;
    }

    public void setNameRoom(String nameRoom){
        this.nameRoom = nameRoom;
    }

    public long getStart(){
        return start;
    }

    public long getEnd(){
        return end;
    }

    public String getIdEvent(){
        return idEvent;
    }

    public String getNameEvent(){
        return nameEvent;
    }

    public String getDescritpion(){
        return description;
    }

    public String getIdOrganizer(){
        return idOrganizer;
    }

    public String getNameOrganizer(){
        return nameOrganizer;
    }

    public String getEmailOrganizer(){
        return emailOrganizer;
    }

    public String getIdRoom(){
        return idRoom;
    }

    public String getNameRoom(){
        return nameRoom;
    }
}
