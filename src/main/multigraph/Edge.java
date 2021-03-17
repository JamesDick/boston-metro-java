package main.multigraph;

/**
 * Represents an Edge between two Nodes in a Graph.
 */
public abstract class Edge {
    private int src;
    private int dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }
}
