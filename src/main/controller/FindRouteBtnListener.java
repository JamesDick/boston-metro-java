package main.controller;

import main.model.IModel;
import main.multigraph.Station;
import main.view.IView;

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

	//This button's action is upon being clicked, the shortest route will be
	// found and displayed in the route list.
	@Override
	public void actionPerformed(ActionEvent e) {
		int src = view.selectedSrcId();
		int dest = view.selectedDestId();
		List<Station> route = model.findRoute(src, dest);
		//Debug purposes System.out.println("Finding route between src=" + src + " and dest="+dest);
		view.clearRoute();
		view.displayRoute(route);
	}
}

