package App;

import App.Empapps.Emplogin;
import App.Userapps.Userlogin;
import java.util.Scanner;

public class Selectview {

    public void selLogin() {

        Selectview sv = new Selectview();
        Userlogin ul = new Userlogin();
        Emplogin el = new Emplogin();

        boolean running = true;

        System.out.println("Please select an option and press Enter: " + "\n" + "1: Login as a User" + "\n" + "2: Login as an Employee" + "\n" + "3: EXIT");

        while (running) {

            int selection = sv.getInput();

            switch (selection) {
                case 1: {
                    System.out.println("\nProceeding to User Login...");
                    ul.loginView();
                    running = false;
                    break;
                }
                case 2: {
                    System.out.println("\nProceeding to Employee Login.");
                    el.loginView();
                    running = false;
                    break;
                }
                case 3: {
                    System.out.println("\nThanks for using MyBank. Goodbye!");
                    running = false;
                    break;
                }
                default: {
                    System.out.println("Please enter a valid option.");
                }
            }
        }
    }


    public int getInput(){

        Scanner scan = new Scanner(System.in);
        int selection = -1;

        while (selection < 0 || selection > 3){

            try{
                System.out.println("Please enter your choice:");
                selection = Integer.parseInt(scan.nextLine());
            }
            catch (NumberFormatException e){
                //e.printStackTrace();
                System.out.println("Invalid selection. please try again:");
            }
        }
        return selection;
    }
}
