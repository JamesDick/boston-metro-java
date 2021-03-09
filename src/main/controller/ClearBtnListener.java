package main.controller;

import main.view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearBtnListener implements ActionListener {
	IView view;
	
	public ClearBtnListener(IView view) {
		this.view = view;
	}

	//This button's action is upon being clicked, a previously found
	// route will be cleared from the displayed route list
	@Override
	public void actionPerformed(ActionEvent e) {
		view.clearRoute();
	}
}
