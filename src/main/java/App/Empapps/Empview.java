package App.Empapps;

import Services.Acctservices;
import Services.Empservices;
import Models.Lo;
import Repositories.Daoacct;
import Repositories.Doaloan;

import java.util.Scanner;

public class Empview {

    Emploanview elv = new Emploanview();

    public void empView(Lo lo) {

        Empview ev = new Empview();
        Acctservices as = new Acctservices();
        Empservices es = new Empservices();
        Daoacct da = new Daoacct();
        Doaloan dl = new Doaloan();

        //System.out.println(acct);


        boolean running = true;

        while (running){

            System.out.println("\nPlease select an option: " + "\n1: View pending loans\n2: EXIT");
            int selection = ev.getIntInput();
            switch (selection) {
                case 1: {
                    System.out.println("\nPending Loans:");
                    elv.selectLoan(lo);
                    running = false;
                    break;
                }
                case 2: {
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
        while (selection < 0 || selection > 2){
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
}
