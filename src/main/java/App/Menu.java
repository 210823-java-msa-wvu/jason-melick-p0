package App;

import java.util.Scanner;
import App.Userapps.Userlogin;
public class Menu {

    //boolean running = true;

    public static void main(String[] args) {
        Menu menu = new Menu();
        //while (menu.running) {
            System.out.println("MyBank App" + "\n" + "Please select from the following:" + "\n" + "1: Log in?" + "\n" + "2: Sign Up for MyBank App" + "\n" + "3: Exit MyBank");
            int selection = menu.getInput();
            switch (selection) {
                case 1: {
                    System.out.println("\nLog in to myBank");
                    Userlogin lv = new Userlogin();
                    lv.loginView();
                    break;
                }
                case 2: {
                    System.out.println("Set up account");
                    break;
                }
                case 3: {
                    System.out.println("Goodbye, and thank you for using MyBank!");
                    //menu.running = false;
                    break;
                }
                default:
                    System.out.println("Please enter a valid option.");
            }
       // }
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
                e.printStackTrace();
                System.out.println("Invalid selection. please try again:");
            }
        }
        return selection;
    }
}


