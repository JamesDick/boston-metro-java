package main.view;

import main.multigraph.*;

import java.util.List;

public interface IView {
	public int selectedSrcId();
	public int selectedDestId();
	public void displayRoute(List<Station> route);
	public void clearRoute();
	public void exit();
}
