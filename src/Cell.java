import java.awt.*;

public class Cell {
    //fields
    int x;
    int y;

    // Static means it wont be modified
    static int size = 35;

    //constructors
    public Cell(int x, int y){
        // x coming in as a parameter should be set to the x I have
        this.x = x;
        this.y = y;
    }

    //methods

    // definiton on how to paint a cell
    void paint(Graphics g, Point mousePos){
        if(contains(mousePos)){
            g.setColor(Color.GRAY);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x,y,size,size);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,size,size);
        
    }

    boolean contains(Point p){
        if(p != null){
            return (x < p.x && x+size > p.x && y < p.y && y+size > p.y);
        } else {
            return false;
        }
    }
}
