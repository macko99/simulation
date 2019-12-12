import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class JSONReader {

    String[] initialDefaultValues;

    JSONReader() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("initialValues.json")) {

            Object obj = parser.parse(reader);

            JSONArray defaultValues = (JSONArray) obj;

            for (Object value : defaultValues) {
                parseDefaultValue((JSONObject) value);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
            this.initialDefaultValues = new String[]{"200", "10", "100", "30", "10", "10", "20", "20", "2000", "10", "1", "1", "10"};
        }

    }

    private void parseDefaultValue(JSONObject value) {
        this.initialDefaultValues = new String[]{(String) value.get("plantsTarget"),
                (String) value.get("adamsTarget"),
                (String) value.get("width"),
                (String) value.get("height"),
                (String) value.get("jungleWidth"),
                (String) value.get("jungleHeight"),
                (String) value.get("plantEnergy"),
                (String) value.get("animalEnergy"),
                (String) value.get("explodeEnergy"),
                (String) value.get("minCopulateEnergy"),
                (String) value.get("moveEnergy"),
                (String) value.get("plantPerDay"),
                (String) value.get("delay")};
    }
}