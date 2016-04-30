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


public class JSON {

    public static void main(String[] args) throws IOException {
        // Array for all the data
        ArrayList<JsonToEvent> data = new ArrayList<JsonToEvent>();

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // //read JSON like DOM Parser
        JsonNode root = objectMapper.readTree(JSON.class.getResource("/test.json"));


        JsonNode dataNode = root.path("data");
        // Data node
        int dataIndex = 0;
        for (JsonNode dataElement : dataNode) {
            data.add(new JsonToEvent());

            // UPDATE: update
            data.get(dataIndex).setUpdate(dataElement.path("updated").asText());
            // UPDATE: start
            data.get(dataIndex).setStart(dataElement.path("start").asText());
            // UPDATE: end
            data.get(dataIndex).setEnd(dataElement.path("end").asText());

            // Enter in the course
            JsonNode courseNode = dataElement.path("course");

            data.get(dataIndex).setIdEvent(courseNode.path("id").asText());
            data.get(dataIndex).setNameEvent(courseNode.path("name_en").asText());
            data.get(dataIndex).setDescription(courseNode.path("description_it").asText());

            // Enter in the Lectures node
            JsonNode lecturesNode = courseNode.path("lecturers");
            // Enter in lecture node
            JsonNode dataNodeLectureNode = lecturesNode.path("data");

            if (dataNodeLectureNode.size() > 0){
                JsonNode dataElementLectureNode = dataNodeLectureNode.get(0);

                JsonNode personNode = dataElementLectureNode.path("person");
                data.get(dataIndex).setIdOrganizer(personNode.path("id").asText());
                data.get(dataIndex).setNameOrganizer(personNode.path("short_name").asText());

                JsonNode emailsNode = personNode.path("emails");
                data.get(dataIndex).setEmailOrganizer(emailsNode.get(0).asText());
            }

            JsonNode placeNode = dataElement.path("place");
            data.get(dataIndex).setIdRoom(placeNode.path("id").asText());
            data.get(dataIndex).setNameRoom(placeNode.path("office").asText());
            data.get(dataIndex).setFloor(placeNode.path("floor").asText());


            dataIndex++;
		}
    }
}
