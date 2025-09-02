import javax.swing.*;
import java.awt.*;

// extends means Main is also a seperate JFrame class
public class Main extends JFrame {

    // Nested Class: JPanel is an area of the screen you can draw on
    class App extends JPanel {

        Grid grid;

        // create constructor
        public App() {
            setPreferredSize(new Dimension(720, 720));
            grid = new Grid();

        }

        @Override
        public void paint(Graphics g) {
            //System.out.println(getMousePosition());
            grid.paint(g, getMousePosition());
        }
    }

    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    // constructor
    private Main() {
        // program terminates upon pressing X
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        App canvas = new App();
        this.setContentPane(canvas);
        // we need to do geometry management to fill the window so it resizes
        this.pack();
        this.setVisible(true);
    }

    public void run(){
        while (true) {
            this.repaint();
        }
    }
}