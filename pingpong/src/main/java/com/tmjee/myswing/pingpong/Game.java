package com.tmjee.myswing.pingpong;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tmjee
 */
public class Game extends JPanel implements Runnable {

    private static final Logger LOG = Logger.getLogger(Game.class.getName());

    private final int width;
    private final int height;

    private volatile Image gameImage;

    private Thread gameThread;
    private volatile boolean running;
    private volatile AbstractState currentState;


    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }


    public void setCurrentState(AbstractState state) {
        state.init();
        this.currentState = state;
    }

    @Override
    public void addNotify() {
        super.addNotify();
    }

    public void start() {
        running = true;
        gameThread = new Thread(this, "gameThread");
        gameThread.start();
    }

    public void stop() {
        running = false;
    }

    public void run() {

            setCurrentState(new LoadState());
            while(running) {
                prepareGameImage();
                AbstractState s = currentState;
                s.update();
                Graphics g = gameImage.getGraphics();
                s.render(g);
                repaint();
                try {
                    Thread.sleep(14);
                } catch(InterruptedException e) {
                    LOG.log(Level.WARNING, e.toString(), e);
                }
            }

        System.exit(0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        if (gameImage == null) {
            return;
        }
        //g.drawString("TESTING", 50, 50);
        g.drawImage(gameImage, 0, 0, this);
    }

    private void prepareGameImage() {
        if (gameImage == null) {
            gameImage = createImage(width, height);
        }
    }

}
