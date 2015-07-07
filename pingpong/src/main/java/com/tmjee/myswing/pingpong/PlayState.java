package com.tmjee.myswing.pingpong;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tmjee
 */
public class PlayState extends AbstractState {

    private static final Logger LOG = Logger.getLogger(PlayState.class.getName());

    private Paddle leftPaddle;
    private Paddle rightPaddle;

    @Override
    public void init() {
        LOG.log(Level.FINE, "init play state");
        int paddleWidth = 10;
        int paddleHeight =20;
        leftPaddle = new Paddle(0, (GameApp.HEIGHT/2)+(paddleHeight/2), paddleWidth, paddleHeight);
        rightPaddle = new Paddle(GameApp.WIDTH-paddleWidth, (GameApp.HEIGHT/2)+(paddleHeight/2), paddleWidth, paddleHeight);
    }

    @Override
    public void update() {
        leftPaddle.update();
        rightPaddle.update();
    }

    @Override
    public void render(Graphics g) {
        // left side
        g.setColor(Resources.DARK_BLUE);
        g.fillRect(0, 0, GameApp.game.width/2, GameApp.game.height);

        // right side
        g.setColor(Resources.DARK_RED);
        g.fillRect(GameApp.game.width/2, 0, GameApp.game.width, GameApp.game.height);

        // line
        g.drawImage(Resources.LINE, GameApp.game.width/2-2, 0, null);

        // left paddle
        g.setColor(Color.WHITE);
        g.fillRect(leftPaddle.getX(), leftPaddle.getY(), leftPaddle.getWidth(), leftPaddle.getHeight());

        // right paddle
        g.setColor(Color.WHITE);
        g.fillRect(rightPaddle.getX(), rightPaddle.getY(), rightPaddle.getWidth(), rightPaddle.getHeight());

    }

    @Override
    public void onClick(MouseEvent e) {
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            leftPaddle.accelerate();
            rightPaddle.deaccelerate();
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            leftPaddle.deaccelerate();
            rightPaddle.accelerate();
        }
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            leftPaddle.stop();
            rightPaddle.stop();
        }
    }
}
