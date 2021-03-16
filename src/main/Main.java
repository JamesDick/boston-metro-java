package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.model.Model;
import main.controller.Controller;
import main.view.MainView;


public class Main extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        Model model = new Model();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
//        loader.setController(new Controller(model));
//        Parent root = loader.load();
//
//        stage.setScene(new Scene(root));
//        stage.setWidth(925);
//        stage.setHeight(650);
////        stage.setResizable(false);
//        stage.show();
        Model model = new Model();
        new MainView(model);
    }
}
