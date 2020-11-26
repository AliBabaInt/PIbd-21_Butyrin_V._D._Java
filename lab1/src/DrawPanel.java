import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    private Tank tank;

    public void paintComponent(Graphics g) {
        if (tank != null) tank.draw(g);
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
