import model.BadFileException;
import model.IModel;
import model.Model;
import multigraph.Station;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        try {
            model.generateGraphFromFile();
        } catch (IOException | BadFileException e) {
            System.out.println(e);
        }
        
        //TEST
        for(Station s : model.findRoute(69, 30)) {
            System.out.println(s.getName());
        }
        
        View view = new View(model);
    }
}
