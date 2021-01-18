package objects;

import interfaces.Drawable;

import java.awt.*;

public class Pendulum implements Drawable {
    final int doteX, doteY, radius;
    final double len, weight;
    private double alpha = 0;

    public Pendulum() {
        this.doteX = 600;
        this.doteY = 90;
        this.len = 350;
        this.weight = 20;
        this.radius = 40;
    }

    public Pendulum(int doteX, int doteY, double len, double weight, int radius) {
        this.doteX = doteX;
        this.doteY = doteY;
        this.len = len;
        this.weight = weight;
        this.radius = radius;
    }

    public int x() {
        return (int) (doteX + len*Math.sin(alpha));
    }

    public int y() {
        return (int) (doteY + len*Math.cos(alpha));
    }

    final static int doteRad = 5;

    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillOval(doteX - doteRad, doteY - doteRad, 2 * doteRad, 2 * doteRad);
        g2d.drawLine(doteX, doteY, x(), y());
        g2d.fillOval(x() - radius, y() - radius, 2*radius, 2*radius);
    }
}
