package com.tmjee.myswing.pingpong;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tmjee
 */
public class Resources {

    private static final Logger LOG = Logger.getLogger(Resources.class.getName());

    public static volatile Image IMAGE_WELCOME;


    public static void load() {
        try {
            LOG.log(Level.FINE, "load resources");
            IMAGE_WELCOME = loadImage("welcome.png");
        }catch(Exception e) {
            LOG.log(Level.WARNING, e.toString(), e);
        }
    }

    public static Image loadImage(String resource) throws IOException {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(resource));
        return ImageIO.read(Thread.currentThread().getContextClassLoader().getResource(resource));
    }

    public static AudioClip loadAudio(String resource) {
        return Applet.newAudioClip(Thread.currentThread().getContextClassLoader().getResource(resource));
    }
}
