package main.model;

public class BadFileException extends Exception{
    public BadFileException(String message){
        System.out.println("Error: " + message);
        System.exit(1);
    }
}
