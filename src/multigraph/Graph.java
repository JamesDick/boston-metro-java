package multigraph;

import java.util.Map;
import java.util.List;


public class Graph {
    private Map<Integer, Node> nodes;
    private List<Edge> edges;

    public boolean addNode(Node N) {

        return true;
    }

    public boolean addEdge(Edge E) {
        edges.add(E);
        return true;
    }
}
