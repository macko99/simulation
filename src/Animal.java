import java.awt.*;

class Animal {

    private Position position;
    private Direction direction;
    private final Gene gene;
    int energy;
    private int daysAlive = 0;
    private int myChildrenCount = 0;
    private final WorldMap map;
    private final int animalEnergy;

    Animal(WorldMap map, Position position, int energy) {
        this.energy = energy;
        this.position = position;
        this.direction = Direction.DEG0;
        this.map = map;
        this.gene = new Gene();
        this.animalEnergy = energy;
    }

    Animal(WorldMap map , Animal parent1, Animal parent2){
        int en1 = parent1.energy/4;
        int en2 = parent2.energy/4;
        parent1.energy-=en1;
        parent2.energy-=en2;
        this.energy = en1 + en2;
        this.animalEnergy = parent1.animalEnergy;
        this.position = parent1.getPosition();
        this.direction = Direction.DEG0;
        this.map = map;
        this.gene = new Gene(parent1.gene, parent2.gene);
        parent1.myChildrenCount++;
        parent2.myChildrenCount++;
    }

    int getDaysAlive(){
        return daysAlive;
    }

    int getMyChildrenCount(){
        return myChildrenCount;
    }

    int getDominantGene(){
        return gene.getDominantGene();
    }

    int[] getMyGene(){
        return gene.getGene();
    }

    Position getPosition() {
        return this.position;
    }

    Direction getDirection() {return this.direction;}

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if(!(other instanceof Animal))
            return false;
        Animal animal = (Animal) other;
        return this.position.equals(animal.position) && this.direction.equals(animal.direction);
    }

    void rotateAndMove(){
        double randomIndex = Math.random()*32;
        int rotateIndex = (int) randomIndex;

        switch (gene.getGene()[rotateIndex]) {
            case 0:
                this.direction = Direction.DEG0;
                break;
            case 1:
                this.direction = Direction.DEG45;
                break;
            case 2:
                this.direction = Direction.DEG90;
                break;
            case 3:
                this.direction = Direction.DEG135;
                break;
            case 4:
                this.direction = Direction.DEG180;
                break;
            case 5:
                this.direction = Direction.DEG225;
                break;
            case 6:
                this.direction = Direction.DEG270;
                break;
            case 7:
                this.direction = Direction.DEG315;
                break;
        }

        Position newPosition = this.position.add(this.direction.toUnitVector());
        newPosition.x = Math.floorMod(newPosition.x, map.getWidth());
        newPosition.y = Math.floorMod(newPosition.y, map.getHeight());
        map.positionChanged(position, newPosition, this);
        this.position = newPosition;
        this.daysAlive++;
    }

    Color toColor(){
        if(energy < animalEnergy ) return new Color(237, 61, 76);
        if(energy < 2*animalEnergy ) return new Color(204, 53, 68);
        if(energy < 5*animalEnergy )return new Color(170, 45, 58);
        if(energy < 7*animalEnergy )return new Color(157, 42, 55);
        if(energy < 10*animalEnergy )return new Color(137, 40, 53);
        if(energy < 20*animalEnergy) return new Color(119, 38, 50);
        if(energy < 25*animalEnergy ) return new Color(99, 34, 46);
        if(energy < 30*animalEnergy )return new Color(78, 29, 43);
        if(energy < 50*animalEnergy )return new Color(76, 30, 39);
        return new Color(52, 21, 26);
    }
}
