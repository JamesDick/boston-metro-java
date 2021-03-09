package main.multigraph;

public abstract class Node {
    private int id;
    private String name;
    
    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Returns id of a station
    public int getId() {
        return this.id;
    }

    //Returns the name of a station's
    public String getName() {
        return this.name;
    }
}
