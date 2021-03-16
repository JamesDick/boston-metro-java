package main;

import javafx.application.Application;
import javafx.stage.Stage;
import main.model.Model;
import main.view.View;


public class Main extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage){
        new View(new Model());
    }
}
