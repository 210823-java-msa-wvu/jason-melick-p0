package App;

import App.Userapps.Usercreate;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Usercreate uc = new Usercreate();
        boolean running = true;

        System.out.println("MyBank App" + "\n" + "Please select from the following:" + "\n" + "1: Log in?" + "\n" + "2: Sign Up for MyBank App" + "\n" + "3: Exit MyBank");

        while (running){

            int selection = menu.getInput();

            switch (selection) {

                case 1: {
                    System.out.println("\nLog in to MyBank as an Employee or existing User");
                    Selectview sv = new Selectview();
                    sv.selLogin();
                    running = false;
                    break;
                }
                case 2: {
                    System.out.println("\nSign up for MyBank");
                    uc.userCreate();
                    running = false;
                    break;
                }
                case 3: {
                    System.out.println("Goodbye, and thank you for using MyBank!");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Please enter a valid option.");
            }
       }
    }


    public int getInput(){

        Scanner scan = new Scanner(System.in);
        int selection = -1;

        while (selection < 0 || selection > 3){

            try{
                System.out.println("Please make a selection:");
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


