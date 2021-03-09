package main.multigraph;

public class Rail extends Edge {
    public String line;
    
    public Rail(int src, int dest, String line) {
        super(src, dest);
        this.line = line;
    }

    //Returns the name/colour of the line a rail is on
    public String getLine() {
        return this.line;
    }
}

