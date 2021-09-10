package App.Userapps;

import Services.Acctservices;
import Services.Stringservices;
import Services.Userservices;
import models.Acct;
import models.User;
import repositories.Daoacct;
import repositories.Daouser;

import java.util.Scanner;

public class Usercreate {


    //Daouser dao = new Daouser();
    //User u = new User();
    //Userservices us = new Userservices();
    Daoacct da = new Daoacct();
    Acctservices as = new Acctservices();
    Userservices us = new Userservices();

    public void userCreate() {
        Usercreate uc = new Usercreate();
        boolean running = true;
        boolean found = false;

       while (running) {
            while (!found) {
                System.out.println("Please enter your SSN. Do not include dashes or spaces:");
                String soc = uc.getSoc();
                System.out.println("Please enter the ID number of your existing account and press enter:");
                Integer id = uc.getAccId();
                if (as.acctExist(soc) && as.idMatch(soc, id)){
                    Acct a = da.getAcctBySsn(soc);
                    if(a.getUserId() == null) {
                        System.out.println("\nAccount found. Please enter your information below:");
                        //us.newUser(a);
                    }else{
                    System.out.println("\nYou are already a MyBank user. Unable to create new account.");
                    }

                } else {
                    //System.out.println("soc: " + soc);
                    // System.out.println("id: " + id);
                    //System.out.println("existing: " + as.acctExist(soc));
                    //System.out.println("matches: " + as.idMatch(soc, id));
                    System.out.println("SSN or Account ID not found. Please try again.");
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
                input = scan.nextInt();
                //System.out.println("input: " + input);
                String soc = String.valueOf(input);
                //System.out.println("soc: " + soc);
                ssn = ssn + soc.substring(0, 3) + "-" + soc.substring(3, 5) + "-" + soc.substring(5);
                //System.out.println("ssn inside getSsn: " + ssn);
                goodSoc = true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                //System.out.println("Not a valid ssn. Please try again");
            }
        }
        //scan.close();
        return ssn;
    }


    public int getIntInput() {

        int selection = -1;
        while (selection < 0) {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Please enter your choice:");
                selection = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Invalid selection. Please try again:");
            }
        }
        return selection;
    }

    public int getAccId(){
        Scanner scan = new Scanner(System.in);
        int id = 0;

        while (id <= 0) {

            try{
                System.out.println("Enter the ID number of your existing account:");
                id = scan.nextInt();
            }catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("ID number not valid. Please try again");
            }
        }
        //scan.close();
        return id;
    }
}