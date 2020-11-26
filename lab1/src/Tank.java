import java.awt.*;

public class Tank {

    private final int tankWidth = 100;
    private final int tankHeight = 60;

    private final Weapons weapons;

    private int _startPosX;
    private int _startPosY;

    private int frameWidth;
    private int frameHeight;

    private int maxSpeed;
    private float weight;

    private Color mainColor;
    private Color secColor;

    private boolean tower;
    private boolean camo;

    public Tank(int maxSpeed, float weight, Color mainColor, Color secColor, boolean tower, boolean camo, int digit) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.secColor = secColor;
        this.tower = tower;
        this.camo = camo;
        this.weapons = new Weapons(digit);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    private void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getWeight() {
        return weight;
    }

    private void setWeight(float weight) {
        this.weight = weight;
    }

    public Color getMainColor() {
        return mainColor;
    }

    private void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public Color getSecColor() {
        return secColor;
    }

    private void setSecColor(Color secColor) {
        this.secColor = secColor;
    }

    public boolean isTower() {
        return tower;
    }

    private void setTower(boolean tower) {
        this.tower = tower;
    }

    public boolean isCamo() {
        return camo;
    }

    private void setCamo(boolean frontBumper) {
        this.camo = camo;
    }

    public void setPosition(int posX, int posY, int frameWidth, int frameHeight) {
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
        if (posX >= 0 && posX + tankWidth < frameWidth &&
                posY >= 0 && posY + tankHeight < frameHeight) {
            this._startPosX = posX;
            this._startPosY = posY;
        }
    }

    public void moveLocomotive(Direction direction) {
        int step = (int) (maxSpeed * 100 / weight);
        switch (direction) {
            case Up:
                if (_startPosY - step > 0) {
                    _startPosY -= step;
                }
                break;
            case Right:
                if (_startPosX + step < frameWidth - step) {
                    _startPosX += step;
                }
                break;
            case Down:
                if (_startPosY + step < frameHeight - tankHeight) {
                    _startPosY += step;
                }
                break;
            case Left:
                if (_startPosX - step > 0) {
                    _startPosX -= step;
                }
                break;
        }
    }

    public void draw(Graphics g) {
        g.setColor(mainColor);
        g.fillRect(_startPosX, _startPosY + 20, tankWidth, 35);

        g.setColor(Color.BLACK);
        g.fillOval(_startPosX + 2, _startPosY + tankHeight - 15, 15, 15);
        g.fillOval(_startPosX + 22, _startPosY + tankHeight - 15, 15, 15);
        g.fillOval(_startPosX + 42, _startPosY + tankHeight - 15, 15, 15);
        g.fillOval(_startPosX + 62, _startPosY + tankHeight - 15, 15, 15);
        g.fillOval(_startPosX + 82, _startPosY + tankHeight - 15, 15, 15);

        if (tower) {
            g.setColor(mainColor);
            g.fillOval(_startPosX + 20, _startPosY, 60, 40);

            weapons.draw(g, getMainColor(), _startPosX, _startPosY);
        }

        if (camo) {
            g.setColor(secColor);
            g.fillOval(_startPosX, _startPosY + 25, 30, 10);
            g.fillOval(_startPosX + 15, _startPosY + 25, 60, 15);
            g.fillOval(_startPosX + 60, _startPosY + 25, 40, 20);
        }


    }
}
