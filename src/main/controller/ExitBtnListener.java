package main.controller;

import javafx.event.*;
import main.view.IView;

/**
 * EventHandler implementation for the Exit Button that exits the program.
 *
 * Requires: n/a
 *
 * Effects: Signals the IView to exit the program.
 *
 * Modifies: n/a
 *
 */
public class ExitBtnListener implements EventHandler<ActionEvent> {
    private IView view;

    public ExitBtnListener(IView view) {
        this.view = view;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        view.exit();
    }
}
