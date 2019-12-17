import java.awt.*;

class Plant {

    private int energy;
    private final Position position;
    private final int plantEnergy;

    Plant(Position position, int energy) {
        this.energy = energy;
        this.position = position;
        this.plantEnergy = energy;
    }

    Position getPosition() {
        return this.position;
    }

    int getEnergy() {
        return energy;
    }

    void setEnergy(int energy) {
        this.energy = energy;
    }

    Color toColor() {
        if (energy > 5 * plantEnergy) return new Color(33, 119, 3);
        if (energy > 4 * plantEnergy) return new Color(36, 144, 3);
        if (energy > 3 * plantEnergy) return new Color(36, 168, 3);
        if (energy > 2 * plantEnergy) return new Color(37, 192, 3);
        if (energy > plantEnergy) return new Color(41, 214, 3);
        return new Color(42, 242, 3);
    }

}
