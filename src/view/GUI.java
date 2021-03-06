package view;

import multigraph.Station;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.util.List;

public class GUI extends JFrame {

    private JFrame frame;
    private JPanel initial;
    private final JList<String>  srcList;
    private final JList<String> destList;
    private final JList<String> routeList;
    private JButton findRouteBtn;
    private JButton clearBtn;
    private JButton exitBtn;

    public GUI(List<Station> stations) {

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(Station s : stations){
            listModel.addElement(s.getName());
        }
        srcList = new JList<>(listModel);
        destList = new JList<>(listModel);
        routeList = new JList<>();
        findRouteBtn = new JButton("Find route");
        clearBtn = new JButton("Clear");
        exitBtn = new JButton("Exit");
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Boston Metro System");

        initial = new JPanel(new GridLayout(3,3,1,1));

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

        initial.add(start);
        initial.add(destination);
        initial.add(route);

        initial.add(new JScrollPane(srcList));
        initial.add(new JScrollPane(destList));
        initial.add(new JScrollPane(routeList));

        initial.add(findRouteBtn);
        initial.add(clearBtn);
        initial.add(exitBtn);

        frame.add(initial);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setLocationRelativeTo(null);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
//        new GUI();
    }
}
