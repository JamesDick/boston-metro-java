package main.multigraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Represents a Graph containing Nodes and Edges.
 * @param <N> Some type N that extends Node.
 * @param <E> Some type E that extends Edge.
 */
public abstract class Graph<N extends Node, E extends Edge> {
    protected Map<Integer, N> nodes;
    protected List<E> edges;
    
    public Graph() {
        nodes = new HashMap<>();
        edges = new ArrayList<>();
    }

    /** Adds a Node to the Graph.
     * Nodes may not contain an ID which is already present in the Graph.
     * @param n The Node to be added.
     * @return true if the Node was added to the Graph, otherwise false.
     */
    public boolean addNode(N n) {
        if (nodes.containsKey(n.getId())) {
            return false;
        }
        
        nodes.put(n.getId(), n);
        return true;
    }
    
    /**
     * Adds an Edge to the Graph.
     * Edges must contain Nodes which already exist in the Graph.
     * @param e The Edge to be added.
     * @return true if the Edge was added to the Graph, otherwise false.
     */
    public boolean addEdge(E e) {
        if (!nodes.containsKey(e.getSrc()) || !nodes.containsKey(e.getDest())) {
            return false;
        }
        
        edges.add(e);
        return true;
    }
}
