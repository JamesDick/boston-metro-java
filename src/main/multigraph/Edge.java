package main.multigraph;

public abstract class Edge {
    private int src;
    private int dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    //Returns starting station's id
    public int getSrc() {
        return src;
    }

    //Returns destionation station's id
    public int getDest() {
        return dest;
    }
}
