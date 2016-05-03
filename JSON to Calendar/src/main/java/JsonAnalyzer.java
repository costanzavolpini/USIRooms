import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.google.api.services.calendar.model.*;



public class JsonAnalyzer {

    public static ArrayList<Event> analyze(String file_name) throws IOException {
        // Array for all the data
        ArrayList<Event> events = new ArrayList<Event>();

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // //read JSON like DOM Parser
        JsonNode root = objectMapper.readTree(JsonAnalyzer.class.getResource("/" + file_name));

        JsonToEvent data;


        JsonNode dataNode = root.path("data");
        // Data node
        int dataIndex = 0;
        for (JsonNode dataElement : dataNode) {
            data = new JsonToEvent();

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

            events.add(data.eventCreator());

            dataIndex++;
		}

        return events;
    }
}
