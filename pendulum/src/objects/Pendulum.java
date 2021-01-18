package objects;

import game.Game;
import interfaces.Drawable;
import interfaces.Updatable;

import java.awt.*;

public class Pendulum implements Drawable, Updatable {
    final int doteX, doteY, radius, period;
    final double len;
    final double weight;
    double startAlpha;
    double alpha, w;


    public Pendulum() {
        this.doteX = 800;
        this.doteY = 90;
        this.len = 400;
        this.weight = 20;
        this.radius = 80;
        this.startAlpha = -0.4;
        this.w = 0.5;
        this.alpha = this.startAlpha;
        this.period = (int) (2 * Math.PI * Math.sqrt(len / Game.G));
    }

    public Pendulum(int doteX, int doteY, double len, double weight, int radius, double startAlpha, double w) {
        this.doteX = doteX;
        this.doteY = doteY;
        this.len = len;
        this.weight = weight;
        this.radius = radius;
        this.startAlpha = startAlpha;
        this.w = w;
        this.alpha = this.startAlpha;
        this.period = (int) (2 * Math.PI * Math.sqrt(len / Game.G));
    }

    public int x() {
        return (int) (doteX + len * Math.sin(alpha));
    }

    public int y() {
        return (int) (doteY + len * Math.cos(alpha));
    }

    final static int doteRad = 5;

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillOval(doteX - doteRad, doteY - doteRad, 2 * doteRad, 2 * doteRad);
        g2d.drawLine(doteX, doteY, x(), y());
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillOval(x() - radius, y() - radius, 2 * radius, 2 * radius);
    }

    @Override
    public void update(long time) {
        time %= period;
        alpha = w * Math.cos(Math.sqrt(Game.G / len) * time + startAlpha);
        if (isBoom()) {
            boom(time);
        }
    }

    private boolean isBoom() {
        return Game.ball.status == 1 && Game.pendulum.radius + Game.ball.radius > Game.dist();
    }

    private void boom(long time) {
        Ball ball = Game.ball;
        ball.status = 2;
        ball.len = Game.dist(ball.x, ball.y, doteX, doteY);
        ball.alpha = -alpha + Math.asin(((double) (ball.x - doteX)) / ball.len);
        double v = (w * Math.sin(Math.sqrt(Game.G / len) * time + startAlpha) * Math.sqrt(Game.G / len)) * len; // real speed
        double ballV = ball.vx * Math.cos(alpha) - ball.vy * Math.sin(alpha);
        double newV = (weight * v + ball.weight * ballV) / (weight + ball.weight);
        w = w * newV / v;
        startAlpha = Math.acos(alpha / w) - Math.sqrt(Game.G / len) * time;
    }
}
