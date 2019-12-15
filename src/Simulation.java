import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Simulation implements ActionListener, MouseListener {

    private final WorldMap map;
    private final Renderer renderer;
    private final StatusBar statusBar;
    private final Timer timer;
    final JFrame frame = new JFrame("Nowy świat - symulacja trwa");
    int dominantGene;

    Simulation(WorldMap map, int delay, int statsTime) {

        MouseListener listener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / renderer.widthScale;
                int y = e.getY() / renderer.heightScale;

                if (map.getAnimalAtPosition(new Position(x, y)) != null) {
                    for (Animal animal : map.getAnimalAtPosition(new Position(x, y))) {
                        new AnimalDetails(animal);
                    }
                }
            }
        };

        this.map = map;
        timer = new Timer(delay, this);

        frame.setSize(1200, 650);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        renderer = new Renderer(map, this);
        renderer.setSize(new Dimension(1, 1));

        statusBar = new StatusBar(map, this, statsTime);
        statusBar.setSize(new Dimension(1, 1));

        renderer.addMouseListener(listener);
        statusBar.addMouseListener(this);

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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(this.timer.isRunning()){
            this.timer.stop();
            frame.setTitle("Nowy świat - PAUZA");
        }
        else{
            this.timer.start();
            frame.setTitle("Nowy świat - symulacja trwa");
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

}
