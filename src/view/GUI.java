package view;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {

    private JFrame frame;

    private void makeFrame() {
        frame = new JFrame("Boston Metro System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
