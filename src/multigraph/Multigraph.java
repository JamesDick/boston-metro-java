package multigraph;

import java.util.List;
import java.util.Map;

public class Multigraph extends  Graph{
    public Map<Integer, Node> nodes;
    public List<Edge> edges;

    public boolean addNode(Station s) {
        return false;
    }

    public boolean addEdge(Rail r) {
        return false;
    }

    public List<Station> findRoute(int srcId, int destId) {
        return null;
    }

    public List<Station> getStations() {
        return null;
    }
}

