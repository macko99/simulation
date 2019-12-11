import javax.swing.*;
import java.awt.*;

public class StatusBar extends JPanel{

    private WorldMap map;
    private  Simulation simulation;
    private int totalDays = 0;

    StatusBar(WorldMap map, Simulation simulation){
        this.map = map;
        this.simulation = simulation;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setSize(simulation.frame.getWidth(),60);
        this.setLocation(0 , simulation.frame.getHeight()-60);
        totalDays++;
        g.drawString("Dni: " + totalDays,20,15);
        g.drawString("Zwierząt: " + map.getAnimalSize(),120,15);
        g.drawString("Roślin: " + map.getPlantSize(),220,15);
        g.drawString("Umarło: " + map.getDeadCount(),320,15);
        g.drawString("Eksplodowało: " + map.getExplodedCount(),430,15);
        g.drawString("Urodziło się: " + map.getBornCount(),560,15);
        g.drawString("2019 Maciej Kozub",800,15);

        if(map.getAnimalSize() == 0){
            simulation.cancelTimer();
            g.drawString("KONIEC",670,15);
        }
    }

}
