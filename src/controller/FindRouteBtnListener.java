package controller;

import model.IModel;
import multigraph.Station;
import view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FindRouteBtnListener implements ActionListener {
	IModel model;
	IView view;
	
	public FindRouteBtnListener(IModel model, IView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int src = view.selectedSrcId();
		int dest = view.selectedDestId();
		List<Station> route = model.findRoute(src, dest);
		view.displayRoute(route);
	}
}
