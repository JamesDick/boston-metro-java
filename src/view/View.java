package view;

import model.IModel;
import multigraph.Station;

import java.util.List;

public class View implements IView {
	
	private GUI gui;
	private IModel model;
	
	public View(IModel model) {
		this.model = model;
	}
	
	@Override
	public int selectedSrcId() {
		return 0;
	}
	
	@Override
	public int selectedDestId() {
		return 0;
	}
	
	@Override
	public void displayRoute(List<Station> route) {
	
	}
	
	@Override
	public void clearRoute() {
	
	}
	
	@Override
	public void exit() {
	
	}
}
