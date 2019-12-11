import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel{

    private WorldMap map;
    private Simulation simulation;

    Renderer(WorldMap map, Simulation simulation){
        this.map = map;
        this.simulation = simulation;
    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        this.setSize(simulation.frame.getWidth(),simulation.frame.getHeight() - 60);

        int width = this.getWidth();
        int height = this.getHeight();
        int widthScale = width/map.width;
        int heightScale = height/map.height;

        g.setColor(new Color(255, 250, 165));
        g.fillRect(0,0,width,height);

        for(Plant plant : map.getPlants()){
            g.setColor(plant.toColor());
            g.fillRect(plant.getPosition().x*widthScale,plant.getPosition().y*heightScale, widthScale, heightScale);
        }

        for(Animal animal : map.getAnimals()){
            g.setColor(animal.toColor());
            g.fillOval(animal.getPosition().x*widthScale, animal.getPosition().y*heightScale,widthScale, heightScale);
        }
    }

}
