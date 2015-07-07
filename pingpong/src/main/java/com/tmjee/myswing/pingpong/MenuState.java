package com.tmjee.myswing.pingpong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tmjee
 */
public class MenuState extends AbstractState {

    private static final Logger LOG = Logger.getLogger(MenuState.class.getName());


    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Resources.IMAGE_WELCOME, 0, 0, null);
    }

    @Override
    public void onClick(MouseEvent e) {
        changeToPlayState();
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        changeToPlayState();
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
    }

    private void changeToPlayState() {
        changeState(new PlayState());
        LOG.log(Level.INFO, "going to Play state");
    }
}
