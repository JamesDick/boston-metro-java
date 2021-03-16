package main.model;

//When reading in the text file we use this class to
// get a clearer message of what went wrong when reading
// in (even though we assume/know the supplied text file
// should parse)
public class BadFileException extends Exception {
    public BadFileException(String message) {
        System.out.println("Error: " + message);
        System.exit(1);
    }
}
