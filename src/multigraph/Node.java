package multigraph;

import java.util.Formatter;

public abstract class Node {
    private int id;
    private String name;
    
    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
