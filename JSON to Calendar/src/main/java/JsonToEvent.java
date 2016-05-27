import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

public class JsonToEvent{
    private  DateTime start;
    private  DateTime end;
    private  String idEvent;
    private  String nameEvent;
    private  String description;
    private  String idOrganizer;
    private  String nameOrganizer;
    private  String emailOrganizer;
    private  String idRoom;
    private  String nameRoom;


    public DateTime StringToDateTime(String inputDate){
        inputDate = inputDate.substring(0, inputDate.length() - 5) + "Z";

        DateTime dateTime = DateTime.parseRfc3339(inputDate);
        Date date = new Date(dateTime.getValue());
        return new Date(dateTime.getValue() + date.getTimezoneOffset() * 60000, -date.getTimezoneOffset());
    }



    public void setStart(String start){
        this.start = StringToDateTime(start);
    }

    public void setEnd(String end){
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

    public Date getStart(){
        return start;
    }

    public Date getEnd(){
        return end;
    }

    public String getIdEvent(){
        return idEvent;
    }

    public String getNameEvent(){
        return nameEvent;
    }

    public String getDescritpio(){
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

    public Stirng getNameRoom(){
        return nameRoom;
    }

}
