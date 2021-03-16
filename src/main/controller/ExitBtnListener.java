package main.controller;

import javafx.event.EventHandler;
import main.view.IView;

public class ExitBtnListener implements EventHandler<javafx.event.ActionEvent> {
    IView view;

    public ExitBtnListener(IView view) {
        this.view = view;
    }

    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {
        view.exit();
    }
}
