import javax.swing.*;
import java.util.Arrays;

class AnimalDetailsPrinter extends JPanel {

    AnimalDetailsPrinter(Animal animal) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel geneL = new JLabel("gen:   ");
        JLabel gene = new JLabel(Arrays.toString(animal.getMyGene()));
        JLabel energyL = new JLabel("energia:   ");
        JLabel energy = new JLabel(String.valueOf(animal.energy));
        JLabel positionL = new JLabel("pozycja:   ");
        JLabel position = new JLabel(animal.getPosition().toString());
        JLabel directionL = new JLabel("kierunek:   ");
        JLabel direction = new JLabel(animal.getDirection().toString());
        JLabel daysAliveL = new JLabel("żyje dni:   ");
        JLabel daysAlive = new JLabel(String.valueOf(animal.getDaysAlive()));
        JLabel childrenCountL = new JLabel("liczba dzieci:   ");
        JLabel childrenCount = new JLabel(String.valueOf(animal.getMyChildrenCount()));

        geneL.setLabelFor(gene);
        energyL.setLabelFor(energy);
        positionL.setLabelFor(position);
        directionL.setLabelFor(direction);
        daysAliveL.setLabelFor(daysAlive);
        childrenCountL.setLabelFor(childrenCount);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();

        p1.add(geneL);
        p1.add(gene);
        p2.add(energyL);
        p2.add(energy);
        p3.add(positionL);
        p3.add(position);
        p4.add(directionL);
        p4.add(direction);
        p5.add(daysAliveL);
        p5.add(daysAlive);
        p6.add(childrenCountL);
        p6.add(childrenCount);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
    }
}