package controller;

import view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearBtnListener implements ActionListener {
	IView view;
	
	public ClearBtnListener(IView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.clearRoute();
	}
}
