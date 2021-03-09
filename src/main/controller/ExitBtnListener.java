package main.controller;

import main.view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitBtnListener implements ActionListener {
	IView view;
	
	public ExitBtnListener(IView view) {
		this.view = view;
	}

	//This button's action is upon being clicked, the application will close
	@Override
	public void actionPerformed(ActionEvent e) {
		view.exit();
	}
}
