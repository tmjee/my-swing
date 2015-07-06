package expriment;


import com.jamescho.game.main.Resources;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 450;

    private volatile Image image;

    public MyJPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null)
            return;
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        new Thread(this).start();
    }

    @Override
    public void run() {

        while(true) {
            if (image == null) {
                image = createImage(WIDTH, HEIGHT);
            }
            Graphics g = image.getGraphics();
            g.clearRect(0, 0, WIDTH, HEIGHT);

            g.drawImage(Resources.welcome, 0,0, null);
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
