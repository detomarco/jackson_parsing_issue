package demo.jackson.kotlin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainKolin {

    private static final ObjectMapper jackson = new ObjectMapper().findAndRegisterModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static void main(String[] args) throws JsonProcessingException {
        var json = "{" +
                "              \"id\": 1,\n" +
                "              \"fruits\": [\n" +
                "                {\n" +
                "                  \"id\": 2,\n" +
                "                  \"tree\": 1,\n" +
                "                  \"calories\": [\n" +
                "                    {\n" +
                "                      \"id\": 3,\n" +
                "                      \"fruit\": 2\n" +
                "                    }\n" +
                "                  ]\n" +
                "                }\n" +
                "              ]\n" +
                "            }";

        jackson.readValue(json, Tree.class);
    }
}
