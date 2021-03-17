package main.controller;

import javafx.event.*;
import main.model.IModel;
import main.view.IView;

/**
 * EventHandler implementation for the Find Route Button that
 * gets the selected Source and Destination Ids from the View
 * and passes these through to the Model in order to find a
 * Route between these stations, then passes the route back
 * to the View for display.
 */
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
