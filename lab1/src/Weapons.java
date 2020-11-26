import java.awt.*;

public class Weapons {

    private CountOfWeapons count;

    public Weapons(int digit) {
        setDigit(digit);
    }

    public void setDigit(int digit) {
        this.count = CountOfWeapons.getCount(digit);
    }

    public void draw(Graphics g, Color color, int x, int y) {
        g.setColor(color);

        switch (count) {
            case one:
                g.fillRect(x + 50, y + 5, 50, 5);
                break;
            case two:
                g.fillRect(x + 50, y + 5, 50, 5);
                g.fillRect(x + 50, y + 11 , 50, 4);
                break;
            case three:
                g.fillRect(x + 50, y + 5, 50, 5);
                g.fillRect(x + 50, y + 11 , 50, 4);
                g.fillRect(x, y + 5, 30, 5);
                break;
        }

    }
}
