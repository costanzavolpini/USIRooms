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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args) throws IOException {
        EventCreator evcreator = new EventCreator();
        Event event = evcreator.createEvent(
          new DateTime("2016-05-28T09:00:00+02:00"),
          new DateTime("2016-05-28T09:00:00+02:00"),
          new DateTime("2016-05-28T10:00:00+02:00"),
          "123456",
          "PF2",
          "Marco culo",
          "567",
          "T. Thomas",
          "marco@costanza.michele",
          "91011",
          "008",
          "0"
        );
        MainCalendar rc = new MainCalendar();
        rc.write(event);
    }

}