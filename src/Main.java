import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    class Canvas extends JPanel {
        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
        }

        @Override
        public void paint(Graphics g) {

            // outer border
            g.setColor(java.awt.Color.BLACK);
            g.drawRect(10, 10, 700, 700);

            // Task3: Draw a 20x20 grid of 35x35 cells starting at (10,10)
            int startX = 10;
            int startY = 10;
            int cellSize = 35;
            int rows = 20;
            for(int r = 0; r < rows; r++) {
                for(int c = 0; c < rows; c++){
                    int x = startX + c * cellSize;
                    int y = startY + r * cellSize;
                    g.drawRect(x,y,cellSize,cellSize);
                }
            }
        }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }

    public void run() {
        while (true) {
            repaint();
        }
    }
}
