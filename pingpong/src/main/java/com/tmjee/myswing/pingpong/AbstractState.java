package com.tmjee.myswing.pingpong;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * @author tmjee
 */
public abstract class AbstractState {

    public abstract void init();
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void onClick(MouseEvent e);
    public abstract void onKeyPress(KeyEvent e);
    public abstract void onKeyRelease(KeyEvent e);


    protected void changeState(AbstractState state) {
        GameApp.game.setCurrentState(state);
    }

}
