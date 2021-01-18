package game;

import interfaces.Drawable;
import objects.Pendulum;

import java.awt.*;
import java.util.ArrayList;

public class Game {
    ArrayList<Drawable> drawables = new ArrayList<>();

    public Game() {
        drawables.add(new Pendulum());
    }

    public void drawAll(Graphics2D g2d) {
        for (Drawable drawable : drawables) {
            drawable.draw(g2d);
        }
    }
}
