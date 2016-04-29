import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class JSON {

    public static void main(String[] args) throws IOException {
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        // //read JSON like DOM Parser
        JsonNode root = objectMapper.readTree(JSON.class.getResource("/test.json"));


        JsonNode dataNode = root.path("data");
        // Data node
        for (JsonNode dataElement : dataNode) {
            System.out.println(dataElement.path("updated"));
		}


        //
        // JsonNode idNode = rootNode.path("data");
        //
        // System.out.println("data = "+idNode.asText());
        //
        // JsonNode phoneNosNode = rootNode.path("data");
        // Iterator<JsonNode> elements = phoneNosNode.elements();
        // while(elements.hasNext()){
        //     JsonNode phone = elements.next();
        //     System.out.println("lecturers = "+phone.asText());
        // }
        // test = root.path("id").asText();
		// JsonNode nameNode = root.path("name");
        //
        // System.out.println(nameNode.path("first"));
        //
        // JsonNode contactNode = root.path("contact");


    }

    public static Employee createEmployee() {

        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("David");
        emp.setPermanent(false);
        emp.setPhoneNumbers(new long[] { 123456, 987654 });
        emp.setRole("Manager");

        Address add = new Address();
        add.setCity("Bangalore");
        add.setStreet("BTM 1st Stage");
        add.setZipcode(560100);
        emp.setAddress(add);

        List<String> cities = new ArrayList<String>();
        cities.add("Los Angeles");
        cities.add("New York");
        emp.setCities(cities);

        Map<String, String> props = new HashMap<String, String>();
        props.put("salary", "1000 Rs");
        props.put("age", "28 years");
        emp.setProperties(props);

        return emp;
    }

}
