import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

class JSONWriter {

    @SuppressWarnings("unchecked")
    JSONWriter(int totalDays, int animalSize, int plantSize, int deadCount, int explodedCount, int bornCount,
               int avgAnimalEnergy, int avgAnimalDaysAlive, int avgAnimalChildrenCount, int dominantGene) {

        JSONObject results = new JSONObject();
        results.put("dni", totalDays);
        results.put("liczba zwierząt", animalSize);
        results.put("liczba roślin", plantSize);
        results.put("umarło", deadCount);
        results.put("eksplodowało", explodedCount);
        results.put("urodziło się", bornCount);
        results.put("średnia energia zwierzęcia", avgAnimalEnergy);
        results.put("średnia długość życia", avgAnimalDaysAlive);
        results.put("średnia liczba dzieci", avgAnimalChildrenCount);
        results.put("gen dominujący", dominantGene);

        try (FileWriter file = new FileWriter("results.json")) {

            file.write(results.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}