package main.controller;

import javafx.event.EventHandler;
import main.view.IView;

public class ClearBtnListener implements EventHandler<javafx.event.ActionEvent> {
	IView view;
	
	public ClearBtnListener(IView view) {
		this.view = view;
	}

	@Override
	public void handle(javafx.event.ActionEvent actionEvent) {
		view.clearRoute();
	}
}
