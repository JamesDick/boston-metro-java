package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.model.Model;
import main.controller.Controller;

public class Main extends Application{
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
        loader.setController(new Controller(model));
        Parent root = loader.load();

        stage.setScene(new Scene(root));
        stage.setWidth(1150);
        stage.setHeight(630);
//        stage.setResizable(false);
        stage.show();
    }

}
