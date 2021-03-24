package main.view;

import main.multigraph.*;

import java.util.List;

/**
 * Interface for interacting with a View in the system.
 */
public interface IView {
    /**
     * Gets the Id of the Station at which the User has indicated they wish to start from.
     *
     * Requires: The user has selected a station to depart from.
     *
     * Effects: Returns the ID of the station at which the user has indicated they want to depart from.
     *
     * Modifies: n/a
     *
     * @return The Id of the specified Station.
     */
    int selectedSrcId();

    /**
     * Gets the Id of the Station at which the User has indicated they want to arrive at.
     *
     * Requires: The user has selected a station to arrive at.
     *
     * Effects: Returns the Id of the source station selected by the user
     *
     * Modifies: n/a
     *
     * @return The Id of the specified Station.
     */
    int selectedDestId();

    /**
     * Displays a given list of Stations as the 'Route' from the source to the destination.
     *
     * Requires: n/a
     *
     * Effects: Takes a List of Stations and displays them on the view.
     *
     * Modifies: The route is displayed on the view.
     *
     * @param route The list of Stations that make up the Route.
     */
    void displayRoute(List<Station> route);

    /**
     * Clears any items from the 'Route' display.
     *
     * Requires: n/a
     *
     * Effects: Clears the route from the display.
     *
     * Modifies: The displayed route should be empty.
     */
    void clearRoute();

    /**
     * Exits the program.
     *
     * Requires: The program to be running.
     *
     * Effects: Exits the program.
     *
     * Modifies: The program is closed.
     */
    void exit();
}
