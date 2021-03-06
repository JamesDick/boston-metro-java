package view;

import model.IModel;
import multigraph.Station;

import java.util.List;

public class View implements IView {
	
	private GUI gui;
	private IModel model;
	
	public View(IModel model) {
		this.model = model;
		gui = new GUI(model.getStations());
	}
	
	@Override
	public int selectedSrcId() {
		return gui.getSrcList().getSelectedIndex();
	}
	
	@Override
	public int selectedDestId() {
		return gui.getDestList().getSelectedIndex();
	}
	
	@Override
	public void displayRoute(List<Station> route) {
		for(Station s : route){
			gui.routeModel.addElement(s.getName());
		}
	}
	
	@Override
	public void clearRoute() {
	
	}
	
	@Override
	public void exit() {
	
	}
}
