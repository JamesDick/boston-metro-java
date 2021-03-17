package main.multigraph;

/**
 * Represents a Rail in the Metro as an Edge in a Graph.
 */
public class Rail extends Edge {
    public String line;

    public Rail(int src, int dest, String line) {
        super(src, dest);
        this.line = line;
    }

    public String getLine() {
        return this.line;
    }
}

