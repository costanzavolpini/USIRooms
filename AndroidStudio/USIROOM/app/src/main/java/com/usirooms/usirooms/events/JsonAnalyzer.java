package com.usirooms.usirooms.events;

import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Marco on 5/29/16.
 */
public class JsonAnalyzer {
    public ArrayList<dummyEvent> analyze(String file_name) throws IOException, ParseException {
        // Array for all the data
        ArrayList<dummyEvent> events = new ArrayList<dummyEvent>();

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // //read JSON like DOM Parser
        JsonNode root = objectMapper.readTree(this.getClass().getClassLoader().getResourceAsStream("res/raw/" + file_name));

        dummyEvent data;


        JsonNode dataNode = root.path("data");
        // Data node
        int dataIndex = 0;
        for (JsonNode dataElement : dataNode) {
            data = new dummyEvent();

            // UPDATE: start
            data.setStart(dataElement.path("start").asText());
            // UPDATE: end
            data.setEnd(dataElement.path("end").asText());

            // Enter in the course
            JsonNode courseNode = dataElement.path("course");

            data.setIdEvent(courseNode.path("id").asText());
            data.setNameEvent(courseNode.path("name_en").asText());
            data.setDescription(courseNode.path("description_it").asText());

            // Enter in the Lectures node
            JsonNode lecturesNode = courseNode.path("lecturers");
            // Enter in lecture node
            JsonNode dataNodeLectureNode = lecturesNode.path("data");

            if (dataNodeLectureNode.size() > 0){
                JsonNode dataElementLectureNode = dataNodeLectureNode.get(0);

                JsonNode personNode = dataElementLectureNode.path("person");
                data.setIdOrganizer(personNode.path("id").asText());
                data.setNameOrganizer(personNode.path("short_name").asText());

                JsonNode emailsNode = personNode.path("emails");
                data.setEmailOrganizer(emailsNode.get(0).asText());
            }

            JsonNode placeNode = dataElement.path("place");
            data.setIdRoom(placeNode.path("id").asText());
            data.setNameRoom(placeNode.path("office").asText());

            events.add(data);

            dataIndex++;
        }
        Log.i("info", dataIndex + " events fetched from \"" + file_name + "\" JSON file");
        return events;
    }
}
