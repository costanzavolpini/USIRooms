import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;

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


    public Event eventCreator(){
        Event event = new Event()

        // Event id, name and description
        .setSummary(idEvent + "_" + nameEvent)
        .setDescription(description)

        // Room id, name and floor
        .setLocation(idRoom + "_" + nameRoom + "_" + floor)

        // Event update, begin, end
        .setUpdated(update);
        EventDateTime begin = new EventDateTime()
            .setDateTime(start)
            .setTimeZone("Europe/Zurich");
        event.setStart(begin);
        EventDateTime ending = new EventDateTime()
            .setDateTime(end)
            .setTimeZone("Europe/Zurich");
        event.setEnd(ending);

        // Organizer id, name and emails
        Event.Organizer organizer = new Event.Organizer()
            .setId(idOrganizer)
            .setDisplayName(nameOrganizer)
            .setEmail(emailOrganizer);
        event.setOrganizer(organizer);

        return event;
    }


    public void setUpdate(String update){
        this.update = StringToDateTime(update);
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

    public void setFloor(String floor){
        this.floor = floor;
    }

}
