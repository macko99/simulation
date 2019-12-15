import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

class AnimalDetails implements MouseListener{

    private final JFrame menuFrame = new JFrame("Szczegóły zwierzęcia");

    AnimalDetails(Animal animal) {
        menuFrame.setSize(500, 250);
        menuFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        menuFrame.add(new AnimalDetailsPrinter(animal));
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
        menuFrame.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        menuFrame.dispatchEvent(new WindowEvent(menuFrame, WindowEvent.WINDOW_CLOSING));
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
