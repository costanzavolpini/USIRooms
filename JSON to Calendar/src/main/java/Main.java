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
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) throws IOException {

        // JSON j = new JSON();
        // j.main(new String[0]);

        ArrayList<Event> events = JsonAnalyzer.analyze("bachelor_inf_3_year.json");
        MainCalendar rc = new MainCalendar();
        //rc.update(events, false, "psl5ie1jhug7m9geanaevl6oi0@group.calendar.google.com");

        List<Event> r = rc.search(new DateTime("2016-02-13T08:59:44Z"), new DateTime("2016-10-13T08:59:44Z"), "psl5ie1jhug7m9geanaevl6oi0@group.calendar.google.com");

        for (Event a : r){
            System.out.println(a);
        }
    }

}
