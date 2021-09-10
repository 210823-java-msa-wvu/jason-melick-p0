package App.Userapps;
import App.Selectview;
import Services.Acctservices;
import Services.Userservices;
import models.User;
import models.Acct;
import repositories.Daoacct;
import repositories.Daouser;
import repositories.Doaloan;

import java.util.Scanner;

public class Userview {

    public void userView(User user) {
        //System.out.println(user);
        Userview uv = new Userview();
        Daouser dao = new Daouser();
        Userservices us = new Userservices();
        Acctservices as = new Acctservices();
        Daoacct da = new Daoacct();
        Doaloan dl = new Doaloan();

        //System.out.println(acct);


        boolean running = true;

        while (running){
            Acct acct = da.getAcctById(user.getuserId());
            System.out.println("\nPlease select an option: " + "\n1: View your balance\n2: Make a deposit\n3: Make a withdrawal\n4: Apply for a loan\n5: EXIT");
            int selection = uv.getIntInput();
            switch (selection) {
                case 1: {
                    System.out.println("\nYour balance is:");
                    System.out.println(acct.getBal());
                    break;
                }
                case 2: {
                    System.out.println("\nMake a deposit");
                    int amt = uv.getAmt();
                    as.deposit(acct, amt);
                    break;
                }
                case 3: {
                    System.out.println("\nMake a withdrawal ");
                    int amt = uv.getAmt();
                    as.withdrawal(acct, amt);
                    //acct = as.withdrawal(acct, amt);
                    //System.out.println("Your new balance is: " + acct.getBal());
                    break;
                }

                case 4: {
                    System.out.println("\nApply for a loan ");
                    int amt = uv.getAmt();
                    dl.createLoan(amt, user);
                    System.out.println("\n$" + amt + " applied for. Approval pending.");
                    break;
                }

                case 5:{
                    System.out.println("\nGoodbye, and thank you for using MyBank!");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    // method to collect input for option selection
    public int getIntInput(){

        int selection = -1;
        while (selection < 0 || selection > 5){
            Scanner scan = new Scanner(System.in);
            try{
                System.out.println("Please enter your choice:");
                selection = Integer.parseInt(scan.nextLine());
            }
            catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("Invalid selection. Please try again:");
            }
        }
        return selection;
    }

    public int getAmt(){
        Scanner scan = new Scanner(System.in);
        int amt = 0;

        while (amt <= 0) {

            try{
                System.out.println("Enter amount:");
                amt = scan.nextInt();
            }catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("Amount not valid. Please try again");
            }
        }
        //scan.close();
        return amt;
    }

}

