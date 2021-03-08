package main.multigraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class Graph<N extends Node, E extends Edge> {
    protected Map<Integer, N> nodes;
    protected List<E> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new ArrayList<>();
    }
    
    public boolean addNode(N n) {
        if (nodes.containsKey(n.getId())) {
            return false;
        }
        
        nodes.put(n.getId(), n);
        return true;
    }

    public boolean addEdge(E e) {
        if (!nodes.containsKey(e.getSrc()) || !nodes.containsKey(e.getDest())) {
            return false;
        }
        
        edges.add(e);
        return true;
    }
}
