package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.model.IModel;
import main.multigraph.Station;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private final List<Station> stationList;

    @FXML
    private ComboBox<String> srcList;
    @FXML
    private ComboBox<String> destList;
    @FXML
    private ListView<String> routeList;
    @FXML
    private ImageView mapView;

    private final IModel model;

    private final ObservableList<String> sourceListItems = FXCollections.observableArrayList();
    private final ObservableList<String> destListItems = FXCollections.observableArrayList();
    private final ObservableList<String> routeListItems = FXCollections.observableArrayList();

    public Controller(IModel model){
        this.model = model;
        stationList = this.model.getStations();
    }

    /**
     * Gets called when the controller is attached to the FXMLLoader.
     * @param url N/A
     * @param resourceBundle N/A
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Station s : stationList){
            sourceListItems.add(s.getName());
            destListItems.add(s.getName());
        }
        srcList.setItems(sourceListItems);
        destList.setItems(destListItems);
        srcList.getSelectionModel().select(1);
        destList.getSelectionModel().select(5);
        routeListItems.add("Press 'Find route' to start");
        routeList.setItems(routeListItems);
    }

    /***
     * Fired when a click is registered in the image.
     * If a station is clicked on, mark it as selected.
     * @param e MouseEvent to be listened.
     */
    @FXML
    public void imageClick(MouseEvent e){
        int x = (int) e.getX();
        int y = (int) e.getY();
        System.out.println("(" + x + ", " + y + ")");
        int stationClicked = coordinateToStation(x, y);
        if (stationClicked >= 0){
            srcList.getSelectionModel().select(stationClicked);
        }
    }

    /**
     * Checks if a given coordinate is within a station boundaries,
     * and returns the corresponding station.
     * @param x x coordinates (starting from 0)
     * @param y y coordinates (starting from 0)
     * @return the index of the selected station
     */
    public int coordinateToStation(int x, int y){
        //OakGrove
        if ((x > 350 && x < 425) && (y > 3 && y < 20)){
            return 0;
        }
        //Malden Center
        if ((x > 350 && x < 425) && (y > 30 && y < 48)){
            return 1;
        }
        //Wellington
        if ((x > 350 && x < 425) && (y > 60 && y < 76)){
            return 4;
        }
        //Sullivan Square
        if ((x > 350 && x < 425) && (y > 89 && y < 107)){
            return 11;
        }
        //Wonderland
        if ((x > 582 && x < 789) && (y > 66 && y < 83)){
            return 2;
        }
        return -1;
    }


    /**
     * When the 'Find route' button is pressed,
     * displays the route between two selected stations.
     * @param e Event to be listened
     */
    @FXML
    public void findRoute(Event e){

        int src = srcList.getSelectionModel().getSelectedIndex() + 1;
        int dest = destList.getSelectionModel().getSelectedIndex() + 1;

        routeListItems.clear();
        List<Station> route = model.findRoute(src, dest);
        int i = 1;
        for(Station s : route){
            routeListItems.add(i + ". " + s.getName());
            i++;
        }
        routeList.setItems(routeListItems);
    }

    /**
     * When the 'Clear' button is pressed, clears the route list.
     * @param e Event to be listened.
     */
    @FXML
    public void clearRoute(Event e){
        routeListItems.clear();
        routeListItems.add("Press 'Find route' to start");
        routeList.setItems(routeListItems);
    }
}