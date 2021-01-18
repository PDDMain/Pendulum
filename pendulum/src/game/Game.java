package game;

import interfaces.Drawable;
import interfaces.Updatable;
import objects.Ball;
import objects.Pendulum;
import objects.Wall;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {
    static long TIME = 0;
    public final static double G = 1;
    ArrayList<Drawable> drawables = new ArrayList<>();
    ArrayList<Updatable> updatables = new ArrayList<>();
    public final static Pendulum pendulum = new Pendulum();
    public final static Ball ball = new Ball();

    public Game() {
        drawables.add(pendulum);
        updatables.add(pendulum);
        drawables.add(ball);
        updatables.add(ball);
        Wall wall = new Wall();
        drawables.add(wall);
    }

    public static int dist(int x, int y, int x1, int y1) {
        return (int) Math.sqrt((x - x1) * (x - x1) +
                (y - y1) * (y - y1));
    }

    public static int dist() {
        return (int) Math.sqrt((pendulum.x() - ball.x()) * (pendulum.x() - ball.x()) +
                (pendulum.y() - ball.y()) * (pendulum.y() - ball.y()));
    }

    public void drawAll(Graphics2D g2d) {
        for (Drawable drawable : drawables) {
            drawable.draw(g2d);
        }
    }

    public void update() {
        for (Updatable updatable : updatables) {
            updatable.update(TIME);
        }
        TIME++;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            ball.start();
        }
    }
}
