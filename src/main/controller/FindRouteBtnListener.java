package main.controller;

import javafx.event.*;
import main.model.IModel;
import main.view.IView;

public class FindRouteBtnListener implements EventHandler<ActionEvent> {
    private IModel model;
    private IView view;

    public FindRouteBtnListener(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int src = view.selectedSrcId();
        int dest = view.selectedDestId();

        view.clearRoute();
        view.displayRoute(model.findRoute(src, dest));
    }
}

