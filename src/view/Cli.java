package view;

import java.util.Scanner;

public class Cli {
    public Cli(){
        prompt();
    }

    /***
     * Prompts the user to choose an option
     */
    public void prompt() {
        Scanner in = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println();
            System.out.print("Type an option: ");
            switch (in.nextLine()) {
                case "1" -> {
                    resetConsole();
                    System.out.println("Option 1 chosen");
                }
                case "2" -> {
                    resetConsole();
                    System.out.println("Option 2 chosen");
                }
                case "0" -> {
                    System.out.println("Exiting...");
                    run = false;
                }
                default -> {
                    resetConsole();
                    System.out.println("Error: invalid input.");
                }
            }
        }
    }


    /***
     * Clears the console
     */
    public void resetConsole(){
        for(int i = 0; i < 60; i++) System.out.println();
        try{
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }else{
                System.out.print("\033[H\033[2J");
            }
        }catch (final Exception e){
            e.printStackTrace();
        }
        printOptions();
        System.out.println();
    }

    /***
     * Prints a list of options
     */
    public void printOptions(){
        System.out.println("Menu:");
        System.out.println("0. Exit");
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
    }
}