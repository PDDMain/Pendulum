package objects;

import game.Game;
import interfaces.Drawable;
import interfaces.Updatable;

import java.awt.*;

public class Ball implements Drawable, Updatable {
    final int startX, startY, radius;
    final double weight;
    int status = 0; // 0 - started, 1 - in fly, 2 - glued to pendulum
    int x, y; // status 0, 1
    int startVx = 16, startVy = -25;
    int vx = startVx, vy = startVy; // status 1
    int len; // status 2
    double alpha; // status 2
    int deltaX, deltaY;

    public Ball() {
        this.startX = 150;
        this.startY = 550;
        this.radius = 16;
        this.weight = 6;
        x = this.startX;
        y = this.startY;
    }

    public Ball(int startX, int startY, int radius, double weight) {
        this.startX = startX;
        this.startY = startY;
        this.radius = radius;
        this.weight = weight;
        x = this.startX;
        y = this.startY;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    @Override
    public void update(long time) {
        if (status == 1 && y > 1000) {
            status = 0;
            x = startX;
            y = startY;
            vx = startVx;
            vy = startVy;
        }
        if (status == 1) {
            x += vx;
            y += vy;
            vy += Game.G;
        } else if (status == 2) {
            x = (int) (Game.pendulum.doteX + len * Math.sin(Game.pendulum.alpha + alpha));
            y = (int) (Game.pendulum.doteY + len * Math.cos(Game.pendulum.alpha + alpha));
        }
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void start() {
        if (status == 0) {
            status = 1;
        } else if (status == 2) {
            status = 0;
            x = startX;
            y = startY;
            vx = startVx;
            vy = startVy;
        }
    }
}
