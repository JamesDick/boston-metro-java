package main.controller;

import javafx.event.*;
import main.view.IView;

public class ClearBtnListener implements EventHandler<ActionEvent> {
    private IView view;

    public ClearBtnListener(IView view) {
        this.view = view;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        view.clearRoute();
    }
}
