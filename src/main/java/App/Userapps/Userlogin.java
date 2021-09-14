package App.Userapps;

import Exceptions.InvalidInputException;
import Services.Stringservices;
import Services.Userservices;
import Models.User;
import Repositories.Daouser;

import java.util.Scanner;

public class Userlogin {

    public void loginView() {

        Userlogin ul = new Userlogin();
        Daouser dao = new Daouser();
        Userservices us = new Userservices();

        boolean running = true;

        while (running) {

            boolean logged = false;

            while (!logged) {

                System.out.println("Please enter your username and press Enter:");
                String uname = ul.getStrInput();

                System.out.println("Please enter your password and press Enter:");
                String pass = ul.getStrInput();

                if (us.credPass(uname, pass) == true) {

                    User user = dao.getByUserName(uname);

                    System.out.println("\nWelcome back " + user.getFirstName() + " " + user.getLastName() + "!");
                    Userview uv = new Userview();

                    uv.userView(user);

                    logged = true;
                    running = false;


                } else {
                    System.out.println("Your username or password do not match our records. Enter '1' to try again, or '2' to EXIT.");

                    switch (ul.getInput()){
                        case 1 : break;

                        case 2: {
                            running = false;
                            break;
                        }
                        default: System.out.println("Please enter a valid option.");
                        }
                    }
                }
            }
        }

    public String getStrInput() {

        Stringservices ss = new Stringservices();
        Scanner scan = new Scanner(System.in);

        boolean valid = false;
        String input = "*";

        while (!valid) {



            try {
                String newInput = scan.nextLine();
                if (ss.isValidUnPass(newInput)) {

                    valid = true;
                    input = newInput;

                } else {

                    System.out.println("Not a valid username/password. Please try again.");

                }
            } catch (InvalidInputException e) {
                //e.printStackTrace();
            }
        }
        return input;
    }

    public int getInput(){

        Scanner scan = new Scanner(System.in);
        int selection = -1;

        while (selection < 0 || selection > 2){
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

/*    public static void main(String[] args){
        Daouser du = new Daouser();
        String uname = "testun1!";
        User user = du.getByUserName(uname);
        System.out.println(user);
    }*/
}
