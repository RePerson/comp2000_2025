import javax.swing.*;
import java.awt.*;

// extends means Main is also a seperate JFrame class
public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    // Nested Class: JPanel is an area of the screen you can draw on
    class Canvas extends JPanel {
        Stage stage = new Stage();

        // create constructor
        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
        }

        @Override
        public void paint(Graphics g) {
            // System.out.println(getMousePosition());
            stage.paint(g, getMousePosition());
        }
    }

    // constructor
    private Main() {
        // program terminates upon pressing X
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        // we need to do geometry management to fill the window so it resizes
        this.pack();
        this.setVisible(true);
    }

    public void run() {
        while (true) {
            this.repaint();
        }
    }
}