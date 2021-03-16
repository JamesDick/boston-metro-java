package main.view;

import main.controller.ClearBtnListener;
import main.controller.ExitBtnListener;
import main.controller.FindRouteBtnListener;
import main.model.IModel;
import main.multigraph.Station;

import java.util.List;

public class View implements IView {
	
	private final GUI gui;

	public View(IModel model) {
		gui = new GUI(model);
		//Attaching listeners
		gui.getFindRouteBtn().setOnAction(new FindRouteBtnListener(model, this));
		gui.getClearBtn().setOnAction(new ClearBtnListener(this));
		gui.getExitBtn().setOnAction(new ExitBtnListener(this));

	}

	@Override
	public int selectedSrcId() {
		return gui.getSrcList().getSelectionModel().getSelectedIndex() + 1;
	}

	@Override
	public int selectedDestId() {
		return gui.getDestList().getSelectionModel().getSelectedIndex() + 1;
	}

	@Override
	public void displayRoute(List<Station> route) {
		gui.getRouteListItems().clear();
		int i = 1;
		for(Station s : route){
			gui.getRouteListItems().add(i + ". " + s.getName());
			i++;
		}
		gui.getRouteList().setItems(gui.getRouteListItems());
	}

	@Override
	public void clearRoute(){
		gui.getRouteListItems().clear();
		gui.getRouteListItems().add("Press 'Find route' to start");
		gui.getRouteList().setItems(gui.getRouteListItems());
	}
	@Override
	public void exit(){
		System.exit(0);
	}
}
