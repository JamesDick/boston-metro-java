package main.view;

import main.multigraph.Station;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.util.List;

public class GUI extends JFrame {
    private JFrame frame;
    private JPanel initial;
    private final JList<String>  srcList;
    private final JList<String> destList;
    private JList<String> routeList;
    private JButton findRouteBtn;
    public DefaultListModel<String> routeModel; // May be private?
    private JButton clearBtn;
    private JButton exitBtn;

    public GUI(List<Station> stations) {
        DefaultListModel<String> stationListModel = new DefaultListModel<>();
        for(Station s : stations) {
            stationListModel.addElement(s.getName());
        }
        
        routeModel = new DefaultListModel<>();
        
        srcList = new JList<>(stationListModel);
        destList = new JList<>(stationListModel);
        routeList = new JList<>(routeModel);
        
        findRouteBtn = new JButton("Find route");
        findRouteBtn.setPreferredSize(new Dimension(200, 100));
        
        clearBtn = new JButton("Clear");
        clearBtn.setPreferredSize(new Dimension(200, 100));
        
        exitBtn = new JButton("Exit");
        exitBtn.setPreferredSize(new Dimension(200, 100));
        
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Boston Metro System");

        initial = new JPanel(new GridLayout(3,3,1,1));

        JPanel findroutePanel = new JPanel();
        findroutePanel.add(findRouteBtn);

        JPanel clearPanel = new JPanel();
        clearPanel.add(clearBtn);

        JPanel exitPanel = new JPanel();
        exitPanel.add(exitBtn);

        initial.setMaximumSize(new Dimension(400, 400));

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

        srcList.setSelectedIndex(0);
        destList.setSelectedIndex(0);

        initial.add(start);
        initial.add(destination);
        initial.add(route);

        initial.add(new JScrollPane(srcList));
        initial.add(new JScrollPane(destList));
        initial.add(new JScrollPane(routeList));

        initial.add(findroutePanel);
        initial.add(clearPanel);
        initial.add(exitPanel);

        frame.add(initial);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setLocationRelativeTo(null);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public JList<String> getSrcList(){
        return this.srcList;
    }

    public JList<String> getDestList(){
        return this.destList;
    }

    public JList<String> getRouteList(){
        return this.routeList;
    }

    public JButton getFindRouteBtn(){
        return this.findRouteBtn;
    }

    public JButton getClearBtn(){
        return this.clearBtn;
    }

    public JButton getExitBtn(){
        return this.exitBtn;
    }
}
