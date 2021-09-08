package App.Userapps;

import Services.Userservices;
import models.User;
import repositories.Daouser;

import java.util.Scanner;

public class Userlogin {

    public void loginView(){
        Userlogin lv = new Userlogin();
        Daouser dao = new Daouser();
        User u = new User();
        Userservices us = new Userservices();
        System.out.println("Please select an option and press Enter: " + "\n" + "1: Login as a User" + "\n" + "2: Login as an employee" + "\n" + "Enter '3' to log out.");
        int selection = lv.getInput();

        switch(selection){
            case 1: {
                boolean logged = false;

                while(!logged){
                System.out.println("Please enter your username and press Enter:");
                String uname = lv.getUnPass();
                System.out.println("Please enter your password and press Enter:");
                String pass = lv.getUnPass();
                if(us.credPass(uname, pass) == true){
                    User creds = dao.getUserCredentials(uname);
                    // System.out.println(creds);
                    System.out.println("Welcome back " + creds.getFirstName() + " " + creds.getLastName() + "Please select an option:");
                    logged = true;
                    break;
                }
                else {
                    System.out.println("Your username or passwords do not match our records. Please try again.");
                }
                }
                break;
            }
            case 2: {
                System.out.println("case 2");
                break;
            }
            case 3: {
                break;
            }

            default: System.out.println("Please enter a valid option.");

        }
    }
    public int getInput(){
        Scanner scan = new Scanner(System.in);
        int selection = -1;
        while (selection < 0 || selection > 2){
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

    public String getUnPass(){
        Scanner scan = new Scanner(System.in);
        String unpass = scan.nextLine();
        return unpass;
    };
}
