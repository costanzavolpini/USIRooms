import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.google.api.client.util.DateTime;

public class JsonToEvent{
    private  DateTime update;
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
    private  String floor;


    public DateTime StringToDateTime(String date){
        date = date.substring(0, date.length() - 4) + "02:00";
        return new DateTime(date);
    }



    public void setUpdate(String update){
        this.update = StringToDateTime(update);
        System.out.println(update);
    }

    public void setStart(String start){
        this.start = StringToDateTime(start);
        System.out.println(start);
    }

    public void setEnd(String end){
        this.end = StringToDateTime(end);
        System.out.println(end);
    }

    public void setIdEvent(String idEvent){
        this.idEvent = idEvent;
        System.out.println(idEvent);
    }

    public void setNameEvent(String nameEvent){
        this.nameEvent = nameEvent;
        System.out.println(nameEvent);
    }

    public void setDescription(String description){
        this.description = description;
        System.out.println(description);
    }

    public void setIdOrganizer(String idOrganizer){
        this.idOrganizer = idOrganizer;
        System.out.println(idOrganizer);
    }

    public void setNameOrganizer(String nameOrganizer){
        this.nameOrganizer = nameOrganizer;
        System.out.println(nameOrganizer);
    }

    public void setEmailOrganizer(String emailOrganizer){
        this.emailOrganizer = emailOrganizer;
        System.out.println(emailOrganizer);
    }

    public void setIdRoom(String idRoom){
        this.idRoom = idRoom;
        System.out.println(idRoom);
    }

    public void setNameRoom(String nameRoom){
        this.nameRoom = nameRoom;
        System.out.println(nameRoom);
    }

    public void setFloor(String floor){
        this.floor = floor;
        System.out.println(floor);
    }



    public DateTime getUpdate(){
        return update;
    }

    public DateTime getStart(){
        return start;
    }

    public DateTime getEnd(){
        return end;
    }

    public String getIdEvent(){
        return idEvent;
    }

    public String getNameEvent(){
        return nameEvent;
    }

    public String getDescription(){
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
}
