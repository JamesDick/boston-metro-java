package main.model;

/**
 * Exception class to be thrown if there is a problem
 * parsing a text file.
 */
public class BadFileException extends Exception {
    public BadFileException(String message) {
        System.out.println("Error: " + message);
        System.exit(1);
    }
}
