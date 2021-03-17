package main.model;

import main.multigraph.Station;

import java.util.List;

/**
 * Interface for interacting with a Model of the system.
 */
public interface IModel {
    /**
     * Finds a route between two specified Stations in the Metro.
     *
     * @param src  The source Station at which we will start.
     * @param dest The destination Station we wish to find a route to.
     * @return A list of Stations connecting the source and destination Stations if found, otherwise null.
     */
    List<Station> findRoute(int src, int dest);

    /**
     * Gets a list of all the Stations in the Metro.
     *
     * @return A list of all the Stations in the Metro.
     */
    List<Station> getStations();
}
