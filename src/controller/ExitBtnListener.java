package controller;

import view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitBtnListener implements ActionListener {
	IView view;
	
	public ExitBtnListener(IView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.exit();
	}}
