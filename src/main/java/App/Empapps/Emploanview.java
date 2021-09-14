package App.Empapps;

import Models.Lo;
import Models.Loan;
import Repositories.Doaloan;
import java.util.ArrayList;
import java.util.Scanner;

public class Emploanview {

    public void selectLoan(Lo lo){

        Emploanview elv = new Emploanview();
        Empapprove ea = new Empapprove();
        Doaloan dl = new Doaloan();

        System.out.println("\nSelect a loan by entering the loan ID, or press '0' to EXIT:");

        boolean running = true;

        while (running) {

            ArrayList<Loan> theseLoans = dl.getAllByStatus("pending");
            theseLoans.forEach(System.out::println);

            int whichLoan = elv.getLoanSelection();

            if(whichLoan == 0){

                running = false;

            }else {

                Loan thisLoan = dl.getById(whichLoan);
                System.out.println(thisLoan);
                Integer thisLoanUserId =  thisLoan.getUserId();
                ea.appLoan(lo, thisLoan, thisLoanUserId);
                running = false;
            }
        }
    }

    public int getLoanSelection(){

        int selection = -1;
        while (selection < 0) {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Please enter Loan ID:");
                selection = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                // e.printStackTrace();
                System.out.println("Invalid selection. Please try again:");
            }

            if (selection == 0) {
                break;
            }
        }
        return selection;
    }
}
