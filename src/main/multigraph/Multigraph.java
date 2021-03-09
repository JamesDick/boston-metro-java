package main.multigraph;

import java.util.*;
import java.util.stream.Collectors;

public class Multigraph extends Graph<Station, Rail> {
    public Multigraph() {
        super();
    }

    //Implementing a Breadth First Search to calculate the shortest route
    // using an agenda to search through and a map to construct the path
    public List<Station> findRoute(int src, int dest) {
        Queue<Integer> agenda = new LinkedList<>(Arrays.asList(src));
        Map<Integer, Integer> parents = new HashMap<>();
        int expansions = 0;
        while (!agenda.isEmpty()) {
            int current = agenda.remove();
            if (current == dest) {
                return reconstructPath(current, parents).stream()
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
    
    public List<Station> getStations() {
        return new ArrayList<>(this.nodes.values());
    }

    //Get the id of the stations that are connected to current station
    private List<Integer> getAdjacentStationIds(int id) {
        return this.edges.stream()
            .filter(e -> e.getSrc() == id && e.getDest() != 0)
            .map(Rail::getDest)
            .distinct()
            .collect(Collectors.toList());
    }

    //Method called to construct the shortest path backtracking from the destination
    // to the starting station using the information of what previous station lead
    // to the current station until the starting/source station is reached
    private List<Integer> reconstructPath(int current, Map<Integer, Integer> parents) {
        List<Integer> path = new ArrayList<>(Arrays.asList(current));
        while(parents.containsKey(current)) {
            current = parents.get(current);
            path.add(0, current);
        }
        return path;
    }
}
