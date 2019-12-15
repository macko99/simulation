import java.util.Comparator;

class EnergyComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal animal, Animal animal2) {
        return -Integer.compare(animal.getEnergy(), animal2.getEnergy());
    }
}