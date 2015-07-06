package com.tmjee.myswing.pingpong;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tmjee
 */
public class LoadState  extends AbstractState {

    private static final Logger LOG = Logger.getLogger(LoadState.class.getName());

    @Override
    public void init() {
        Resources.load();
    }

    @Override
    public void update() {
        changeState(new MenuState());
        LOG.log(Level.FINE, "changed state to menu state");
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
