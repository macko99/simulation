import javax.swing.*;
import java.awt.*;

class Renderer extends JPanel {

    private final WorldMap map;
    private final Simulation simulation;
    int widthScale;
    int heightScale;

    Renderer(WorldMap map, Simulation simulation) {
        this.map = map;
        this.simulation = simulation;
        this.setSize(simulation.frame.getWidth(), simulation.frame.getHeight() - 60);

        widthScale =  this.getWidth() / map.getWidth();
        heightScale = this.getHeight() / map.getHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setSize(simulation.frame.getWidth(), simulation.frame.getHeight() - 60);

        g.setColor(new Color(255, 250, 165));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (Plant plant : map.getPlants()) {
            g.setColor(plant.toColor());
            g.fillRect(plant.getPosition().x * widthScale, plant.getPosition().y * heightScale, widthScale, heightScale);
        }

        for (Animal animal : map.getAnimals()) {
            g.setColor(animal.toColor());
            g.fillOval(animal.getPosition().x * widthScale, animal.getPosition().y * heightScale, widthScale, heightScale);
        }
    }

}
