package com.tmjee.myswing.pingpong;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author tmjee
 */
public class GameApp extends JFrame {

    public static final String TITLE="Java Game";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 450;

    public static Game game;


    public static void main(String[] args) throws Exception {

        Resources.load();

        game = new Game(WIDTH, HEIGHT);

        final GameApp gameApp = new GameApp();
        gameApp.add(game);
        gameApp.setResizable(false);
        gameApp.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                game.stop();
                System.exit(0);
            }
        });
        gameApp.pack();
        gameApp.setVisible(true);
        game.start();
    }
}
