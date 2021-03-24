package main.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.model.IModel;
import main.multigraph.Station;

import java.util.List;

/**
 * Represents a JavaFX GUI.
 */
public class GUI {

    private final List<Station> stationList;
    private ListView<String> routeList;

    private Button findRouteButton;
    private Button clearButton;
    private Button exitButton;

    private final ObservableList<String> sourceListItems = FXCollections.observableArrayList();
    private final ObservableList<String> destListItems = FXCollections.observableArrayList();
    private final ObservableList<String> routeListItems = FXCollections.observableArrayList();

    private ComboBox<String> srcList;
    private ComboBox<String> destList;

    /**
     * Class constructor.
     *
     * @param model model reference.
     */
    public GUI(IModel model) {
        this.stationList = model.getStations();
        Stage stage = new Stage();

        stage.setScene(new Scene(generateMainPane()));
        stage.setResizable(false);
        stage.getIcons().add(new Image("main/view/icon.png"));
        stage.show();
    }

    /**
     * Creates the main Pane of the GUI with an image on the left
     * and options on the right side.
     *
     *  Requires: An instantiated class extending Application
     *
     *  Effects: Creates the main Pane of the app, containing a map image and a side options Pane.
     *
     *  Modifies: n/a
     *
     * @return a BorderPane.
     */
    public BorderPane generateMainPane() {

        Image image = new Image("main/view/map.png");
        ImageView mapView = new ImageView();
        BorderPane bPane = new BorderPane();

        mapView.setImage(image);
        bPane.setLeft(mapView);
        bPane.setRight(generateOptions());

        return bPane;
    }

    /**
     * Right section of the GUI containing options and
     * a list of the generated route.
     *
     * Requires: an instantiated class extending Application
     *
     * Effects: creates an options Pane, containing interactive controls.
     *
     * Modifies: n/a
     *
     * @return an AnchorPane
     */
    public AnchorPane generateOptions() {
        AnchorPane aPane = new AnchorPane();
        GridPane gPane = new GridPane();

        //Components
        srcList = new ComboBox<>();
        destList = new ComboBox<>();
        routeList = new ListView<>();
        findRouteButton = new Button("Find Route");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");

        //Setting lists models
        for (Station s : stationList) {
            sourceListItems.add(s.getName());
            destListItems.add(s.getName());
        }
        srcList.setItems(sourceListItems);
        destList.setItems(destListItems);
        srcList.getSelectionModel().select(1);
        destList.getSelectionModel().select(5);
        routeListItems.add("Press 'Find route' to start");
        routeList.setItems(routeListItems);

        //Row 0
        gPane.add(new Label("Depart From:"), 0, 0);
        gPane.add(srcList, 1, 0);
        //Row 1
        gPane.add(new Label("Arrive At:"), 0, 1);
        gPane.add(destList, 1, 1);
        //Grid settings
        gPane.setPadding(new Insets(15, 15, 15, 15));
        gPane.setHgap(20);
        gPane.setVgap(10);

        //Positioning
        findRouteButton.setLayoutX(18);
        findRouteButton.setLayoutY(561);
        clearButton.setLayoutX(115);
        clearButton.setLayoutY(561);
        exitButton.setLayoutX(180);
        exitButton.setLayoutY(561);
        routeList.setLayoutX(15);
        routeList.setLayoutY(101);
        //Sizing
        aPane.setPrefWidth(230);
        aPane.setMaxWidth(230);
        aPane.setMinWidth(230);
        routeList.setPrefWidth(200);
        srcList.setPrefWidth(107);
        destList.setPrefWidth(107);

        //Anchors
        AnchorPane.setBottomAnchor(findRouteButton, 14.1);
        AnchorPane.setBottomAnchor(clearButton, 14.1);
        AnchorPane.setBottomAnchor(exitButton, 14.1);
        AnchorPane.setRightAnchor(exitButton, 15.2);
        AnchorPane.setLeftAnchor(gPane, 0.0);
        AnchorPane.setLeftAnchor(routeList, 15.0);

        aPane.getChildren().addAll(gPane, routeList, findRouteButton, clearButton, exitButton);
        return aPane;
    }

    public Button getFindRouteBtn() {
        return findRouteButton;
    }

    public Button getClearBtn() {
        return clearButton;
    }

    public Button getExitBtn() {
        return exitButton;
    }

    public ComboBox<String> getSrcList() {
        return srcList;
    }

    public ComboBox<String> getDestList() {
        return destList;
    }

    public ListView<String> getRouteList() {
        return routeList;
    }

    public ObservableList<String> getRouteListItems() {
        return routeListItems;
    }
}