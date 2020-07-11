package life;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private Universe universe;

    @Override
    protected void paintComponent(Graphics g) {
        // clear the previous painting
        super.paintComponent(g);
        // cast Graphics to Graphics2D
        Graphics2D g2 = (Graphics2D) g;

        if (universe != null) {
            int size = universe.getSize();
            float xStep = (float) getWidth() / size;
            float yStep = (float) getHeight() / size;
            boolean[][] field = universe.getField();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    g2.setColor(Color.black);
                    if (field[j][i]) {
                        g2.fillRect((int) (j * xStep), (int) (i * yStep), (int) xStep, (int) yStep);
                    } else {
                        g2.drawRect((int) (j * xStep), (int) (i * yStep), (int) xStep, (int) yStep);
                    }
                }
            }
        }
    }

    public void printField(Universe universe) {
        removeAll();
        this.universe = universe;
        repaint();
    }
}
