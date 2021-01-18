package objects;

import interfaces.Drawable;

import java.awt.*;

public class Wall implements Drawable {
    final int x, y, width, height;

    public Wall() {
        this.x = 50;
        this.y = 566;
        this.width = 200;
        this.height = 84;
    }

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(x, y, width, height);
    }
}
