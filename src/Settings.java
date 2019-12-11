import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JPanel implements ActionListener {

    private JTextField plantsTarget;
    private JTextField adamsTarget;
    private JTextField width;
    private JTextField height;
    private JTextField jungleWidth;
    private JTextField jungleHeight;
    private JTextField plantEnergy;
    private JTextField animalEnergy;
    private JTextField explodeEnergy;
    private JTextField minCopulateEnergy;
    private JTextField moveEnergy;
    private JTextField plantPerDay;
    private JTextField delay;

    Settings(String[] defaultValues) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        plantsTarget = new JTextField();
        plantsTarget.setColumns(10);
        plantsTarget.setText(defaultValues[0]);

        adamsTarget = new JTextField();
        adamsTarget.setColumns(10);
        adamsTarget.setText(defaultValues[1]);

        width = new JTextField();
        width.setColumns(10);
        width.setText(defaultValues[2]);

        height = new JTextField();
        height.setColumns(10);
        height.setText(defaultValues[3]);

        jungleWidth = new JTextField();
        jungleWidth.setColumns(10);
        jungleWidth.setText(defaultValues[4]);

        jungleHeight = new JTextField();
        jungleHeight.setColumns(10);
        jungleHeight.setText(defaultValues[5]);

        plantEnergy = new JTextField();
        plantEnergy.setColumns(10);
        plantEnergy.setText(defaultValues[6]);

        animalEnergy = new JTextField();
        animalEnergy.setColumns(10);
        animalEnergy.setText(defaultValues[7]);

        explodeEnergy = new JTextField();
        explodeEnergy.setColumns(10);
        explodeEnergy.setText(defaultValues[8]);

        minCopulateEnergy = new JTextField();
        minCopulateEnergy.setColumns(10);
        minCopulateEnergy.setText(defaultValues[9]);

        moveEnergy = new JTextField();
        moveEnergy.setColumns(10);
        moveEnergy.setText(defaultValues[10]);

        plantPerDay = new JTextField();
        plantPerDay.setColumns(10);
        plantPerDay.setText(defaultValues[11]);

        delay = new JTextField();
        delay.setColumns(10);
        delay.setText(defaultValues[12]);

        JLabel plantsTargetL = new JLabel("Roślin na początku (na strefę):   ");
        JLabel adamsTargetL = new JLabel("Zwierząt na początku:     ");
        JLabel widthL = new JLabel("Szerekość mapy:     ");
        JLabel heightL = new JLabel("Wysokość mapy:     ");
        JLabel jungleWidthL = new JLabel("Szerokość dżungli:    ");
        JLabel jungleHeightL = new JLabel("Wysokość dżungli:    ");
        JLabel plantEnergyL = new JLabel("Energia rośliny:  ");
        JLabel animalEnergyL = new JLabel("Początkowa energia zwierzęcia:   ");
        JLabel explodeEnergyL = new JLabel("Maksymalna energia zwierzęcia:  ");
        JLabel minCopulateEnergyL = new JLabel("MInimalna energia rozmnażania:  ");
        JLabel moveEnergyL = new JLabel("Energia poruszania się:    ");
        JLabel plantPerDayL = new JLabel("Liczba nowych roślin na dzień (na strefę):    ");
        JLabel delayL = new JLabel("Odświeżanie (ms):    ");

        plantsTargetL.setLabelFor(plantsTarget);
        adamsTargetL.setLabelFor(adamsTarget);
        widthL.setLabelFor(width);
        heightL.setLabelFor(height);
        jungleWidthL.setLabelFor(width);
        jungleHeightL.setLabelFor(jungleHeight);
        plantEnergyL.setLabelFor(plantEnergy);
        animalEnergyL.setLabelFor(animalEnergy);
        explodeEnergyL.setLabelFor(explodeEnergy);
        minCopulateEnergyL.setLabelFor(minCopulateEnergy);
        moveEnergyL.setLabelFor(moveEnergy);
        plantPerDayL.setLabelFor(plantPerDay);
        delayL.setLabelFor(delay);

        JButton button = new JButton("Start!");
        button.addActionListener(this);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();
        JPanel p10 = new JPanel();
        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();
        JPanel p13 = new JPanel();
        JPanel p14 = new JPanel();

        p1.add(plantsTargetL);
        p1.add(plantsTarget);
        p2.add(adamsTargetL);
        p2.add(adamsTarget);
        p3.add(widthL);
        p3.add(width);
        p4.add(heightL);
        p4.add(height);
        p5.add(jungleWidthL);
        p5.add(jungleWidth);
        p6.add(jungleHeightL);
        p6.add(jungleHeight);
        p7.add(plantEnergyL);
        p7.add(plantEnergy);
        p8.add(animalEnergyL);
        p8.add(animalEnergy);
        p9.add(explodeEnergyL);
        p9.add(explodeEnergy);
        p10.add(minCopulateEnergyL);
        p10.add(minCopulateEnergy);
        p11.add(moveEnergyL);
        p11.add(moveEnergy);
        p12.add(plantPerDayL);
        p12.add(plantPerDay);
        p13.add(delayL);
        p13.add(delay);
        p14.add(button);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        add(p8);
        add(p9);
        add(p10);
        add(p11);
        add(p12);
        add(p13);
        add(p14);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        WorldMap map = new WorldMap(
                Integer.parseInt(plantsTarget.getText()),
                Integer.parseInt(adamsTarget.getText()),
                Integer.parseInt(width.getText()),
                Integer.parseInt(height.getText()),
                Integer.parseInt(jungleWidth.getText()),
                Integer.parseInt(jungleHeight.getText()),
                Integer.parseInt(plantEnergy.getText()),
                Integer.parseInt(animalEnergy.getText()),
                Integer.parseInt(explodeEnergy.getText()),
                Integer.parseInt(minCopulateEnergy.getText()),
                Integer.parseInt(moveEnergy.getText()),
                Integer.parseInt(plantPerDay.getText())
        );

        new Simulation(map, Integer.parseInt(delay.getText()));

    }
}

