package myswing.button;

import javax.swing.*;
import java.awt.*;

/**
 * @author tmjee
 */
public class Main1 {

    public static class MainFrame extends JFrame {
        public MainFrame() {
            super();
            setTitle("Main1 - Button");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            getContentPane().setLayout(new GridLayout(3,1,30,30));


            // toggle button
            JPanel toggleButtonsPanel = new JPanel();
            toggleButtonsPanel.setBorder(BorderFactory.createTitledBorder("JToggleButton"));
            toggleButtonsPanel.add(new JToggleButton("JToggleButton 1"));
            toggleButtonsPanel.add(new JToggleButton("JToggleButton 2"));
            toggleButtonsPanel.add(new JToggleButton("JToggleButton 3"));
            getContentPane().add(toggleButtonsPanel);


            // grouped toggle Buttons
            JPanel groupedToggleButtonsPanel = new JPanel();
            groupedToggleButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
            groupedToggleButtonsPanel.setBorder(BorderFactory.createTitledBorder("Grouped JToggleButton"));
            ButtonGroup buttonGroup = new ButtonGroup();
            JToggleButton jToggleButton1 = new JToggleButton("JToggleButton 1");
            JToggleButton jToggleButton2 = new JToggleButton("JToggleButton 2");
            JToggleButton jToggleButton3 = new JToggleButton("JToggleButton 3");
            groupedToggleButtonsPanel.add(jToggleButton1);
            groupedToggleButtonsPanel.add(jToggleButton2);
            groupedToggleButtonsPanel.add(jToggleButton3);
            buttonGroup.add(jToggleButton1);
            buttonGroup.add(jToggleButton2);
            buttonGroup.add(jToggleButton3);
            getContentPane().add(groupedToggleButtonsPanel);


            pack();
            setVisible(true);
        }



    }




    public static void main(String[] args) throws Exception {
        new MainFrame();
    }
}
