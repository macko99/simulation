import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Simulation implements ActionListener {

    private final WorldMap map;
    private final Renderer renderer;
    private final StatusBar statusBar;
    private final Timer timer;
    final JFrame frame = new JFrame("Nowy świat - symulacja trwa");

    Simulation(WorldMap map, int delay) {

        this.map = map;
        timer = new Timer(delay, this);

        frame.setSize(1200, 650);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        renderer = new Renderer(map, this);
        renderer.setSize(new Dimension(1, 1));

        statusBar = new StatusBar(map, this);
        statusBar.setSize(new Dimension(1, 1));

        frame.add(renderer);
        frame.add(statusBar);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        map.day();
        renderer.repaint();
        statusBar.repaint();

    }

    void cancelTimer() {
        this.timer.stop();
        frame.setTitle("Nowy świat - KONIEC");
    }

}
