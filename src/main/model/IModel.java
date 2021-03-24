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
     * Requires: Multigraph is populated with Nodes and Edges such that Nodes indicated by src
     *           and dest exist in the Graph, and that there are sufficient Edges to form a route between them.
     *
     * Effects:	A List of Stations is returned indicating the Route between the src and dest Stations.
     *
     * Modifies: n/a
     *
     * @param src  The source Station at which we will start.
     * @param dest The destination Station we wish to find a route to.
     * @return A list of Stations connecting the source and destination Stations if found, otherwise null.
     */
    List<Station> findRoute(int src, int dest);

    /**
     * Gets a list of all the Stations in the Metro.
     *
     * Requires: Multigraph is populated such that every station within the Boston Metro System has been added to the
     *           Multigraph.
     *
     * Effects:	A List of all the Stations in the Metro.
     *
     * Modifies: n/a
     *
     * @return A list of all the Stations in the Metro.
     */
    List<Station> getStations();
}
