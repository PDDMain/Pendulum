import game.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Main {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
    final static JFrame FRAME = new JFrame("ФИЗИКА = ЛЮБОВЬ!");
//    public static Image BACKGROUND;
    public static Game game = new Game();

    private static class MyPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
//            g2d.drawImage(BACKGROUND, 0, 0, Main.WIDTH, Main.HEIGHT, null);
            game.drawAll(g2d);
        }
    }


    public static void main(String[] args) throws IOException {
        FRAME.setSize(WIDTH, HEIGHT);
        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FRAME.setLayout(new BorderLayout());
//        BACKGROUND = ImageIO.read(new File("wallpaper.png")).getScaledInstance(HEIGHT, WIDTH, Image.SCALE_SMOOTH);

        Timer drawableTimer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FRAME.repaint();
            }
        });
        drawableTimer.start();

        MyPanel panel = new MyPanel();
        FRAME.add(panel);
        FRAME.setVisible(true);
    }
}