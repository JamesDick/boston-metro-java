package main;

import main.model.Model;
import main.multigraph.Station;
import main.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        
        //TEST
        for(Station s : model.findRoute(1, 33)) { // change to 33 to trigger exception
            System.out.println(s.getName());
        }
        
        View view = new View(model);
    }
}
