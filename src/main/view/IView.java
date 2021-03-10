package main.view;

import main.multigraph.*;

import java.util.List;

public interface IView {
	/**
	 * Gets the Id of the Station at which the User has indicated they wish to start from.
	 * @return The Id of the specified Station.
	 */
	int selectedSrcId();
	
	/**
	 * Gets the Id of the Station at which the User has indicated they with to arrive at.
	 * @return The Id of the specified Station.
	 */
	int selectedDestId();
	
	/**
	 * Displays a given list of Stations as the 'Route' from the source to the destination.
	 * @param route The list of Stations that make up the Route.
	 */
	void displayRoute(List<Station> route);
	
	/**
	 * Clears any items from the 'Route' display.
	 */
	void clearRoute();
	
	/**
	 * Exits the program.
	 */
	void exit();
}
