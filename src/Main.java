import model.BadFileException;
import model.IModel;
import model.Model;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        try {
            model.generateGraphFromFile();
        }catch (IOException | BadFileException e){
            System.out.println(e);
        }
        View view = new View(model);

    }
}
