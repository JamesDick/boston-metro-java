package view;

import controller.ClearBtnListener;
import controller.ExitBtnListener;
import controller.FindRouteBtnListener;
import model.IModel;
import multigraph.Station;

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
	
	@Override
	public int selectedSrcId() {
		return gui.getSrcList().getSelectedIndex() + 1;
	}
	
	@Override
	public int selectedDestId() {
		return gui.getDestList().getSelectedIndex() + 1;
	}
	
	@Override
	public void displayRoute(List<Station> route) {
		for(Station s : route){
			gui.routeModel.addElement(s.getName());
		}
	}
	
	@Override
	public void clearRoute() {
		gui.routeModel.clear();
	}
	
	@Override
	public void exit() {
		System.exit(0);
	}
}
