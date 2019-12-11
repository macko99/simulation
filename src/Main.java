import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String[] initialDefaultValues = new JSONReader().initialDefaultValues;

        JFrame menuFrame = new JFrame("Ustawienia symulatora");
        menuFrame.setSize(500,500);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.add(new Settings(initialDefaultValues));
        menuFrame.setVisible(true);

    }
}
