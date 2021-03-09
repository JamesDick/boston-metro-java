package main.view;

import main.controller.ClearBtnListener;
import main.controller.ExitBtnListener;
import main.controller.FindRouteBtnListener;
import main.model.IModel;
import main.multigraph.Station;

import java.util.List;

public class View implements IView {
	
	private GUI gui;
	private IModel model;
	
	public View(IModel model) {
		this.model = model;
		gui = new GUI(model.getStations());
		gui.getFindRouteBtn().addActionListener(new FindRouteBtnListener(model, this));
		gui.getClearBtn().addActionListener(new ClearBtnListener(this));
		gui.getExitBtn().addActionListener(new ExitBtnListener(this));
	}

	//Returns the index of the selected station within the source
	// list displayed
	@Override
	public int selectedSrcId() {
		return gui.getSrcList().getSelectedIndex() + 1;
	}

	//Returns the index of the selected station within the destination
	// list displayed
	@Override
	public int selectedDestId() {
		return gui.getDestList().getSelectedIndex() + 1;
	}

	//Displays the quickest route between the selected source and destination
	// stations
	@Override
	public void displayRoute(List<Station> route) {
		for(Station s : route){
			gui.routeModel.addElement(s.getName());
		}
	}

	//Clears the route that was previously found and displayed
	@Override
	public void clearRoute() {
		gui.routeModel.clear();
	}

	//Closes the application
	@Override
	public void exit() {
		System.exit(0);
	}
}
