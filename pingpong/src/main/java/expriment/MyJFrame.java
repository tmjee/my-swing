package expriment;

import com.jamescho.game.main.Resources;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

    public static Image image;

    public static MyJPanel myJPanel;

    public static void main(String[] args) throws Exception {

            Resources.load();

            image = Toolkit.getDefaultToolkit().getImage(MyJFrame.class.getResource("/welcome.png"));

            myJPanel = new MyJPanel();

            MyJFrame myJFrame = new MyJFrame();
            myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myJFrame.setResizable(false);
            myJFrame.setIconImage(Resources.iconimage);
            myJFrame.add(myJPanel);
            myJFrame.pack();
        myJFrame.pack();
        myJFrame.pack();
            myJFrame.setVisible(true);
    }
}
