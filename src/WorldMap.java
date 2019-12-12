import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.*;

class WorldMap {

    final int width;
    final int height;
    private final int plantEnergy;
    private final int jungleHeight;
    private final int jungleWidth;
    private final int animalEnergy;
    private final int explodeEnergy;
    private final int minCopulateEnergy;
    private final int moveEnergy;
    private final int plantPerDay;
    private int bornCount = 0;
    private int deadCount = 0;
    private int explodedCount = 0;

    private final Map<Position, Plant> plantsMap = new HashMap<>();
    private final MultiValuedMap<Position, Animal> animals = new ArrayListValuedHashMap<>();

    WorldMap(int plantsTarget, int adamsTarget, int width, int height, int jungleWidth, int jungleHeight,
             int plantEnergy, int animalEnergy, int explodeEnergy, int minCopulateEnergy, int moveEnergy, int plantPerDay) {
        this.width = width;
        this.height = height;
        this.plantEnergy = plantEnergy;
        this.jungleHeight = jungleHeight;
        this.jungleWidth = jungleWidth;
        this.animalEnergy = animalEnergy;
        this.explodeEnergy = explodeEnergy;
        this.minCopulateEnergy = minCopulateEnergy;
        this.moveEnergy = moveEnergy;
        this.plantPerDay = plantPerDay;

        growPlants(plantsTarget);
        AdamAndEve(adamsTarget);
    }

    private void growPlants(int Target) {
        for (int i = 0; i < Target; i++) {
            double randomX = Math.random() * this.width;
            double randomY = Math.random() * this.height;

            double jungleRandomX = Math.random() * this.jungleWidth + (getJungleLowerX());
            double jungleRandomY = Math.random() * this.jungleHeight + (getJungleLowerY());

            Position vectorInt = new Position((int) randomX, (int) randomY);
            Position jungleVectorInt = new Position((int) jungleRandomX, (int) jungleRandomY);

            checkSpot(vectorInt, plantsMap.get(vectorInt));
            checkSpot(jungleVectorInt, plantsMap.get(jungleVectorInt));
        }
    }

    private void checkSpot(Position vector, Plant plant) {
        if (plant != null) {
            plant.energy += plantEnergy / 2;
            plantsMap.put(vector, plant);
        } else if (!animals.containsKey(vector)) {
            plantsMap.put(vector, new Plant(vector, plantEnergy));
        }
    }

    private void AdamAndEve(int adamsTarget) {
        for (int i = 0; i < adamsTarget; i++) {
            double randomX = Math.random() * this.width;
            double randomY = Math.random() * this.height;

            Position vectorInt = new Position((int) randomX, (int) randomY);
            Animal newAnimal = new Animal(this, vectorInt, animalEnergy);

            animals.put(newAnimal.getPosition(), newAnimal);
        }
    }

    void day() {
        removeDead();

        List<Animal> animalsL = new ArrayList<>(animals.values());
        for (Animal animal : animalsL) {
            animal.rotateAndMove();
        }

        eat();
        growPlants(plantPerDay);
        copulate();
    }

    private void removeDead() {
        List<Animal> dead = new ArrayList<>();

        for (Map.Entry<Position, Animal> entry : animals.entries()) {
            entry.getValue().energy = entry.getValue().energy - moveEnergy;
            if (entry.getValue().energy < 1) {
                deadCount++;
                dead.add(entry.getValue());
            }
            if (entry.getValue().energy > explodeEnergy) {
                explodedCount++;
                dead.add(entry.getValue());
            }
        }

        for (Animal animal : dead) {
            animals.removeMapping(animal.getPosition(), animal);
        }
    }

    private void eat() {
        for (Position position : animals.keys()) {
            if (plantsMap.containsKey(position)) {
                List<Animal> findEaters = new ArrayList<>(animals.get(position));
                findEaters.sort(new EnergyComparator());
                findEaters.removeIf(e -> e.energy < findEaters.get(0).energy);

                int addedEnergy = plantsMap.get(position).energy / findEaters.size();
                plantsMap.remove(position);

                for (Animal animal : findEaters) {
                    animal.energy += addedEnergy;
                }
            }
        }
    }

    private void copulate() {
        for (Position position : animals.keys()) {
            if (animals.get(position).size() > 1) {
                List<Animal> findParents = new ArrayList<>(animals.get(position));
                findParents.sort(new EnergyComparator());
                findParents.subList(0, 2);
                if (findParents.get(0).energy > minCopulateEnergy && findParents.get(1).energy > minCopulateEnergy) {
                    Animal child = new Animal(this, findParents.get(0), findParents.get(1));
                    bornCount++;
                    animals.put(child.getPosition(), child);
                }
            }
        }
    }

    void positionChanged(Position oldPosition, Position newPosition, Animal animal) {
        animals.removeMapping(oldPosition, animal);
        animals.put(newPosition, animal);
    }

    int getAnimalSize() {
        return animals.size();
    }

    int getPlantSize() {
        return plantsMap.size();
    }

    int getBornCount() {
        return bornCount;
    }

    int getDeadCount() {
        return deadCount;
    }

    int getExplodedCount() {
        return explodedCount;
    }

    List<Plant> getPlants() {
        return new ArrayList<>(plantsMap.values());
    }

    List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }

    private int getJungleLowerX() {
        return this.width / 2 - this.jungleWidth / 2;
    }

    private int getJungleLowerY() {
        return this.height / 2 - this.jungleHeight / 2;
    }

}
