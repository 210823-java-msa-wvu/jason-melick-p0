package App.Userapps;

import Services.Stringservices;
import Services.Userservices;
import models.User;
import repositories.Daouser;

import java.util.Scanner;

public class Userlogin {

    public void loginView() {
        Userlogin ul = new Userlogin();
        Daouser dao = new Daouser();
        User u = new User();
        Userservices us = new Userservices();
        //System.out.println("Please select an option and press Enter: " + "\n" + "1: Login as a User" + "\n" + "2: Login as an employee" + "\n" + "3: EXIT.");
        boolean running = true;

        while (running) {
            boolean logged = false;
            Scanner scan = new Scanner(System.in);
            while (!logged) {
                System.out.println("Please enter your username and press Enter:");
                String uname = ul.getStrInput();
                // System.out.println(uname);
                // String uname = scan.nextLine();
                System.out.println("Please enter your password and press Enter:");
                String pass = ul.getStrInput();
                // String pass = scan.nextLine();
                if (us.credPass(uname, pass) == true) {
                    User user = dao.getByUserName(uname);
                    //System.out.println(user);
                    System.out.println("\nWelcome back " + user.getFirstName() + " " + user.getLastName() + "!");
                    Userview uv = new Userview();
                    uv.userView(user);
                    running = false;
                    logged = true;
                } else {
                    System.out.println("Your username or password do not match our records. Please try again.");
                }
            }
        }
    }

    public String getStrInput() {
        Stringservices ss = new Stringservices();
        Scanner scan = new Scanner(System.in);
        //scan.close();
        boolean valid = false;
        String input = "*";
        while (!valid) {
            //scan.nextLine();
            //System.out.println(valid);
            String newInput = scan.nextLine();
            //System.out.println("newInput " + newInput);
            if (ss.isValidUnPass(newInput)) {
                valid = true;
                // System.out.println("valid " + valid);
                input = newInput;
            } else {
                System.out.println("Input contains invalid characters. Please try again.");
            }
        }
        return input;
    }
}
