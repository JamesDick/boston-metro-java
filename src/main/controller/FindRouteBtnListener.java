package main.controller;

import javafx.event.EventHandler;
import main.model.IModel;
import main.view.IView;

public class FindRouteBtnListener implements EventHandler<javafx.event.ActionEvent> {
    IModel model;
    IView view;

    public FindRouteBtnListener(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {

        int src = view.selectedSrcId();
        int dest = view.selectedDestId();

        view.clearRoute();
        view.displayRoute(model.findRoute(src, dest));
    }
}

