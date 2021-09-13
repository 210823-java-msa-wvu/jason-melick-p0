package App.Userapps;

import Services.Acctservices;
import Services.Userservices;
import Models.Acct;
import Repositories.Daoacct;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Usercreate {

    Daoacct da = new Daoacct();
    Acctservices as = new Acctservices();
    Userservices us = new Userservices();
    Userlogin ul = new Userlogin();

    public void userCreate() {

        Usercreate uc = new Usercreate();

        boolean running = true;
        boolean found = false;

       while (running) {

            while (!found) {

                System.out.println("Please enter your SSN. Do not include dashes or spaces:");
                String soc = uc.getSoc();
                Integer id = uc.getAccId();

                if (as.acctExist(soc) && as.idMatch(soc, id)){

                    Acct a = da.getAcctBySsn(soc);

                    if(a.getUserId() == null || a.getUserId() == 0) {

                        System.out.println("\nAccount found. Please enter your information below:");
                        found = true;
                        us.newUser(a);
                        ul.loginView();

                    }else{

                        System.out.println("\nYou are already a MyBank user. Unable to create new account.");
                        ul.loginView();
                        found = true;

                    }

                } else {

                    System.out.println("SSN or Account ID not found. Do you wish to:\n1: Try again?\n2: EXIT");

                    int choice = uc.getInput();

                    switch (choice){

                        case 1: {

                            break;
                        }

                        case 2: {

                            running = false;
                            System.out.println("Goodbye, and thank you for using MyBank!");
                            break;
                        }
                        default: System.out.println("A problem occurred while making your selection. Please try again.");
                    }
                }
            }
        }
    }

    public String getSoc() {

        Scanner scan = new Scanner(System.in);
        int input = 0;
        String ssn = "";
        boolean goodSoc = false;

        while (!goodSoc && String.valueOf(input).length() < 9 && input < 100000000) {

            try {
                input = Integer.parseInt(scan.nextLine());
                String soc = String.valueOf(input);
                ssn = ssn + soc.substring(0, 3) + "-" + soc.substring(3, 5) + "-" + soc.substring(5);
                goodSoc = true;

            } catch (NumberFormatException|InputMismatchException e) {
                //e.printStackTrace();
                System.out.println("Not a valid ssn. Please try again");

            }
        }
        return ssn;
    }

    public int getAccId(){

        Scanner scan = new Scanner(System.in);
        int id = 0;

        while (id <= 0) {

            try{
                System.out.println("Enter the ID number of your existing account:");
                id = Integer.parseInt(scan.nextLine());

            }catch (NumberFormatException | InputMismatchException e){
                //e.printStackTrace();
                System.out.println("ID number not valid. Please try again");
            }
        }
        return id;
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
                //e.printStackTrace();
                System.out.println("Invalid selection. please try again:");
            }
        }
        return selection;
    }
}