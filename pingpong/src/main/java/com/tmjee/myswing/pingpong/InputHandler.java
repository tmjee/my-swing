package com.tmjee.myswing.pingpong;

import java.awt.event.*;

/**
 * @author tmjee
 */
public class InputHandler implements KeyListener, MouseListener {

    private volatile AbstractState state;

    public void setState(AbstractState state) {
        this.state = state;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        state.onKeyPress(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        state.onKeyPress(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        state.onClick(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
