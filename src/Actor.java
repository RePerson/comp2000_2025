import java.awt.Graphics;
import java.awt.Color;

// we cannot go along the code and cannot say new actor due to abstract
public abstract class Actor {
    Color color;
    Cell loc;

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(loc.x + 5, loc.y + 5, loc.width - 10, loc.height - 10);
    }

}
