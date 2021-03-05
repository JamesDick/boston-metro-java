package view;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class GUI extends JFrame {

    private JFrame frame;
    private JPanel initial;

    public GUI() {
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Boston Metro System");

        initial = new JPanel(new GridLayout(1,3,1,1));

        JLabel start = new JLabel("Start");
        start.setFont(new Font("Helvetica", Font.BOLD, 30));
        start.setVerticalAlignment(JLabel.CENTER);
        start.setHorizontalAlignment(JLabel.CENTER);

        JLabel destination = new JLabel("Destination");
        destination.setFont(new Font("Helvetica", Font.BOLD, 30));
        destination.setVerticalAlignment(JLabel.CENTER);
        destination.setHorizontalAlignment(JLabel.CENTER);

        JLabel route = new JLabel("Route");
        route.setFont(new Font("Helvetica", Font.BOLD, 30));
        route.setVerticalAlignment(JLabel.CENTER);
        route.setHorizontalAlignment(JLabel.CENTER);

        initial.add(start,0,0);
        initial.add(destination,0,1);
        initial.add(route,0,2);

        frame.add(initial);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setLocationRelativeTo(null);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
