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
import main.controller.ClearBtnListener;
import main.controller.ExitBtnListener;
import main.controller.FindRouteBtnListener;
import main.model.IModel;
import main.multigraph.Station;
import java.util.List;

public class MainView implements IView{

    private final IModel model;
    private final List<Station> stationList;
    private ListView<String> routeList;

    private final ObservableList<String> sourceListItems = FXCollections.observableArrayList();
    private final ObservableList<String> destListItems = FXCollections.observableArrayList();
    private final ObservableList<String> routeListItems = FXCollections.observableArrayList();

    private ComboBox<String> srcList;
    private ComboBox<String> destList;

    public MainView(IModel model){
        this.model = model;
        this.stationList = model.getStations();
        Stage stage = new Stage();

        stage.setScene(new Scene(generateMainPane()));
        stage.setResizable(false);
        stage.show();
    }

    public BorderPane generateMainPane(){

        Image image = new Image("main/view/map.png");
        ImageView mapView = new ImageView();
        BorderPane bPane = new BorderPane();

        mapView.setImage(image);
        bPane.setLeft(mapView);
        bPane.setRight(generateOptions());

        return bPane;
    }

    /**
     * Right section of the GUI.
     * Contains a GridPane for the labels and combo-boxes.
     * @return AnchorPane
     */
    public AnchorPane generateOptions(){
        AnchorPane aPane = new AnchorPane();
        GridPane gPane = new GridPane();

        //Components
        srcList = new ComboBox<>();
        destList = new ComboBox<>();
        routeList = new ListView<>();
        Button findRouteButton = new Button("Find Route");
        Button clearButton = new Button("Clear");
        Button exitButton = new Button("exit");

        //Setting lists models
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


        //Attaching listeners
        exitButton.setOnAction(new ExitBtnListener(this));
        clearButton.setOnAction(new ClearBtnListener(this));
        findRouteButton.setOnAction(new FindRouteBtnListener(model, this));

        //Anchors
        AnchorPane.setBottomAnchor(findRouteButton, 14.1);
        AnchorPane.setBottomAnchor(clearButton, 14.1);
        AnchorPane.setBottomAnchor(exitButton, 14.1);
        AnchorPane.setRightAnchor(exitButton, 15.2);
        AnchorPane.setLeftAnchor(gPane, 0.0);
        AnchorPane.setLeftAnchor(routeList, 15.0);

        aPane.getChildren().addAll(gPane, routeList, findRouteButton, clearButton, exitButton);
        //AnchorPane border(debug)
//        aPane.setBorder(new Border(new BorderStroke(Color.BLACK,
//                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        return aPane;
    }

    @Override
    public int selectedSrcId() {
        return srcList.getSelectionModel().getSelectedIndex() + 1;
    }

    @Override
    public int selectedDestId() {
        return destList.getSelectionModel().getSelectedIndex() + 1;
    }

    @Override
    public void displayRoute(List<Station> route) {
        routeListItems.clear();
        int i = 1;
        for(Station s : route){
            routeListItems.add(i + ". " + s.getName());
            i++;
        }
        routeList.setItems(routeListItems);
    }

    @Override
    public void clearRoute(){
        routeListItems.clear();
        routeListItems.add("Press 'Find route' to start");
        routeList.setItems(routeListItems);
    }
    @Override
    public void exit(){
        System.exit(0);
    }
}
