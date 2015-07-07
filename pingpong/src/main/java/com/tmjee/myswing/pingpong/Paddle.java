package com.tmjee.myswing.pingpong;

import java.awt.*;

/**
 * @author tmjee
 */
public class Paddle {

    private int x, y;
    private final int width, height;
    private final Rectangle rect;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(x, y, width, height);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }


}
