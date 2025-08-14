import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    class Canvas extends JPanel {
        public Grid grid;

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
            grid = new Grid(20, 20, 35, 10, 10);
        }

        @Override
        public void paint(Graphics g) {
            g.setColor(java.awt.Color.BLACK);

            // Get mouse position relative to this panel
            Point mousePos = getMousePosition();
            if (mousePos != null) {
                grid.updateHover(mousePos.x, mousePos.y);
            } else {
                grid.clearHover();
            }

            grid.paint(g);
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

    // Task 4 + 5: Cell class
    public static class Cell {
        public int x, y, size;

        public Cell(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        public void paint(Graphics g, boolean highlighted) {
            if (highlighted) {
                g.setColor(java.awt.Color.LIGHT_GRAY);
            } else {
                g.setColor(java.awt.Color.WHITE);
            }
            g.fillRect(x, y, size, size);
            g.setColor(java.awt.Color.BLACK);
            g.drawRect(x, y, size, size);
        }
    }

    // Task 4 + 5: Grid class
    public static class Grid {
        public int rows, cols, cellSize, startX, startY;
        public Cell[][] cells;
        public int hoverRow = -1;
        public int hoverCol = -1;

        public Grid(int rows, int cols, int cellSize, int startX, int startY) {
            this.rows = rows;
            this.cols = cols;
            this.cellSize = cellSize;
            this.startX = startX;
            this.startY = startY;

            cells = new Cell[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int x = startX + c * cellSize;
                    int y = startY + r * cellSize;
                    cells[r][c] = new Cell(x, y, cellSize);
                }
            }
        }

        public void updateHover(int mouseX, int mouseY) {
            if (mouseX >= startX && mouseX < startX + cols * cellSize
                    && mouseY >= startY && mouseY < startY + rows * cellSize) {
                hoverCol = (mouseX - startX) / cellSize;
                hoverRow = (mouseY - startY) / cellSize;
            } else {
                hoverRow = -1;
                hoverCol = -1;
            }
        }

        public void clearHover() {
            hoverRow = -1;
            hoverCol = -1;
        }

        public void paint(Graphics g) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    boolean highlighted = (r == hoverRow && c == hoverCol);
                    cells[r][c].paint(g, highlighted);
                }
            }
            g.drawRect(startX, startY, cols * cellSize, rows * cellSize);
        }
    }
}
