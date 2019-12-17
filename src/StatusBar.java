import javax.swing.*;
import java.awt.*;

class StatusBar extends JPanel {

    private final WorldMap map;
    private final Simulation simulation;
    private final int statsTime;
    private int totalDays = 0;

    StatusBar(WorldMap map, Simulation simulation, int statsTime) {
        this.map = map;
        this.simulation = simulation;
        this.statsTime = statsTime;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setSize(simulation.frame.getWidth(), 60);
        this.setLocation(0, simulation.frame.getHeight() - 60);
        totalDays++;
        if (totalDays == statsTime) {
            new JSONWriter(totalDays, map.getAnimalSize(), map.getPlantSize(), map.getDeadCount(),
                    map.getExplodedCount(), map.getBornCount(), map.getAvgAnimalEnergy(), map.getAvgAnimalDaysAlive(),
                    map.getAvgAnimalChildrenCount(), simulation.dominantGene);
        }
        simulation.dominantGene = map.getMapDominateGene();
        g.drawString("Dni: " + totalDays, 15, 15);
        g.drawString("Zwierząt: " + map.getAnimalSize(), 100, 15);
        g.drawString("Roślin: " + map.getPlantSize(), 210, 15);
        g.drawString("Umarło: " + map.getDeadCount(), 310, 15);
        g.drawString("Eksplodowało: " + map.getExplodedCount(), 425, 15);
        g.drawString("Urodziło się: " + map.getBornCount(), 540, 15);
        g.drawString("śr. energia: " + map.getAvgAnimalEnergy(), 670, 15);
        g.drawString("śr. dni: " + map.getAvgAnimalDaysAlive(), 790, 15);
        g.drawString("śr. dzieci: " + map.getAvgAnimalChildrenCount(), 885, 15);
        g.drawString("dom. gen: " + simulation.dominantGene, 970, 15);
        g.drawString("STOP/START", 1070, 15);
        g.drawRoundRect(1065, 0, 90, 21, 5, 5);

        if (map.getAnimalSize() == 0) {
            simulation.cancelTimer();
        }
    }

}
