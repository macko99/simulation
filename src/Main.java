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

       /* WorldMap map = new WorldMap(200, 100,
                100, 30, 10, 10, 20, 100,
                2000, 1, 1, 1);
        for(int i=0; i<100; i++){
            map.day();
            System.out.println("");
            System.out.println("");
        }*/

    }
}
