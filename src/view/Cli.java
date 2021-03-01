package view;

import java.util.Scanner;

public class Cli {
    public Cli(){
        prompt();
    }

    public void prompt() {
        Scanner in = new Scanner(System.in);
        boolean run = true;
        while (run) {
            switch (in.nextLine()) {
                case "1":
                    resetConsole();
                    System.out.println("Option 1 chosen");
                    break;
                case "2":
                    resetConsole();
                    System.out.println("Option 2 chosen");
                    break;
                case "0":
                    resetConsole();
                    System.out.println("Exiting...");
                    run = false;
                    break;
            }
        }
    }
        public void resetConsole(){
            try
            {
                final String os = System.getProperty("os.name");

                if (os.contains("Windows")) {
                    Runtime.getRuntime().exec("cls");
                }
                else {
                    Runtime.getRuntime().exec("clear");
                }
            }
            catch (final Exception e)
            {
                //  Exception here
            }
        }


}