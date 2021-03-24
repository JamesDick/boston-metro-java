package main.multigraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Represents a Graph containing Nodes and Edges.
 *
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

    /**
     * Adds a Node to the Graph.
     *
     * Requires: No Node already exists in the Graph with the same ID as the given Node.
     *
     * Effects: Checks if the current station has already been created
     *          and if not it is added to the Graph and we return true, otherwise we return false.
     *
     * Modifies: A Node will potentially be added to the Graph.
     *
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
     *
     * Requires: Nodes exist in the Graph matching the ID of the
     *           source and destination Nodes of the given Edge.
     *
     * Effects: Checks whether the source and destination nodes of
     *          the Edge already exist in the Graph,
     *          if they do, the Edge is added and we return true,
     *          otherwise we return false.
     *
     * Modifies: An Edge will potentially be added to the Graph.
     *
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
