package main.multigraph;

import java.util.*;
import java.util.stream.Collectors;

public class Multigraph extends Graph<Station, Rail> {
    public Multigraph() {
        super();
    }
    
    /**
     * Finds a route between two specified Stations in the Metro.
     * @param src The source Station at which we will start.
     * @param dest The destination Station we wish to find a route to.
     * @return A list of Stations connecting the source and destination Stations if found, otherwise null.
     */
    public List<Station> findRoute(int src, int dest) {
        Queue<Integer> agenda = new LinkedList<>(Arrays.asList(src));
        Map<Integer, Integer> parents = new HashMap<>();
        int expansions = 0;
        while (!agenda.isEmpty()) {
            int current = agenda.remove();
            if (current == dest) {
                return reconstructPath(current, parents)
                        .stream()
                        .map(s -> nodes.get(s))
                        .collect(Collectors.toList());
            }
            
            if (expansions++ < 1000) {
                List<Integer> adjacent = getAdjacentStationIds(current);
                adjacent.forEach(station -> {
                    if(!parents.containsKey(station) && station != src) {
                        agenda.add(station);
                        parents.put(station, current);
                    }
                });
            }
        }
    
        return null;
    }
    
    /**
     * Gets a list of all the Stations in the Metro.
     * @return A list of all the Stations in the Metro.
     */
    public List<Station> getStations() {
        return new ArrayList<>(this.nodes.values());
    }
    
    /**
     * Gets the Ids of all the Stations that the specified Station is connected to by Rail.
     * @param id The Id of the specified Station.
     * @return A list of Station Ids.
     */
    private List<Integer> getAdjacentStationIds(int id) {
        return this.edges
                .stream()
                .filter(e -> e.getSrc() == id && e.getDest() != 0)
                .map(Rail::getDest)
                .distinct()
                .collect(Collectors.toList());
    }
    
    /**
     * Reconstructs the path from a given Station to the source Station.
     * @param current The Station from which we wish to reconstruct a path.
     * @param parents A map where the Key is a given Station Id,
     *                and the Value is the Id of the Station from which it was expanded.
     * @return A list of Station Ids connecting the source Station to the destination Station.
     */
    private List<Integer> reconstructPath(int current, Map<Integer, Integer> parents) {
        List<Integer> path = new ArrayList<>(Arrays.asList(current));
        while(parents.containsKey(current)) {
            current = parents.get(current);
            path.add(0, current);
        }
        return path;
    }
}
