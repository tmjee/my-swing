package com.tmjee.myswing.pingpong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tmjee
 */
public class Game extends JPanel implements Runnable {

    private static final Logger LOG = Logger.getLogger(Game.class.getName());

    public final int width;
    public final int height;

    private volatile Image gameImage;

    private final InputHandler inputHandler;

    private Thread gameThread;
    private volatile boolean running;
    private volatile AbstractState currentState;


    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
        this.inputHandler = new InputHandler();
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
        LOG.log(Level.INFO, "testing");
        Game.this.addKeyListener(inputHandler);
        Game.this.addMouseListener(inputHandler);
        running = true;
        gameThread = new Thread(this, "gameThread");
        gameThread.start();
    }

    public void stop() {
        running = false;
    }

    public void run() {

            AbstractState initialState = new LoadState();
            setCurrentState(initialState);

            while(running) {
                AbstractState s = currentState;

                inputHandler.setState(s);
                prepareGameImage();

                Image i = gameImage;
                Graphics g = i.getGraphics();

                s.update();
                s.render(g);

                gameImage = i;
                repaint();

                try {
                    Thread.sleep(14);
                } catch(InterruptedException e) {
                    LOG.log(Level.WARNING, e.toString(), e);
                }
            }
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
            gameImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }
    }
}
