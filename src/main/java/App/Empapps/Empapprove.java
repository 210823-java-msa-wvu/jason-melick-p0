package App.Empapps;
import Services.Stringservices;
import Models.Loan;
import Models.Lo;
import Models.User;
import Models.Acct;
import Repositories.Daoacct;
import Repositories.Daouser;
import Repositories.Doaloan;

import java.util.Scanner;

public class Empapprove {

    Daoacct da = new Daoacct();
    Stringservices ss = new Stringservices();

    Doaloan dl = new Doaloan();
    Daouser du = new Daouser();
    Emploanview elv = new Emploanview();

    public void appLoan(Lo emp, Loan loan, Integer id) {
        Empapprove ea = new Empapprove();
        // System.out.println("appLoan User ID test: " + id);
        Acct acct = da.getAcctById(id);
        User user = du.getById(id);
        System.out.println("\nLoan Amount: $ " + loan.getLoanAmt() +
                "\nApplicant's current account balance: $ " + acct.getBal() +
                "\nApplicant's FICO score: " + user.getFico());

        boolean running = true;

        while (running) {

            System.out.println("Press 'A' to Approve, 'D' to  Deny, 'R' to Return to loans, or 'X' to EXIT");
            String selection = ea.getLetterInput();
            switch (selection) {
                case "a": {
                    System.out.println("Updating loan status.");
                    Integer empId = emp.getEmpId();
                    Integer loanId = loan.getLoanId();
                    loan.setStatus("approved");
                    dl.updateStatus(empId, loanId, loan);
                    System.out.println("Returning to Pending Loans");
                    elv.selectLoan(emp);
                    running = false;
                    break;
                }
                case "d": {
                    System.out.println("Updating loan status.");
                    Integer empId = emp.getEmpId();
                    Integer loanId = loan.getLoanId();
                    loan.setStatus("denied");
                    dl.updateStatus(empId, loanId, loan);
                    System.out.println("Returning to Pending Loans");
                    elv.selectLoan(emp);
                    running = false;
                    break;
                }

                case "r": {
                    System.out.println("Returning to Pending Loans");
                    elv.selectLoan(emp);
                    running = false;
                    break;
                }

                case "x": {
                    System.out.println("\nGoodbye, and thank you for using MyBank!");
                    running = false;
                    break;
                }

                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }


    public String getLetterInput() {
        Stringservices ss = new Stringservices();
        Scanner scan = new Scanner(System.in);

        boolean valid = false;
        String letter = "";
        String letters = "adrx";

        while (!valid) {

            String newInput = scan.nextLine().toLowerCase();

            if (ss.isLetter(newInput) && newInput.length() == 1) {

                if(letters.contains(newInput)){
                valid = true;
                letter = newInput;

                }
            } else {
                System.out.println("Input contains invalid characters. Please try again.");
            }
        }
        return letter;
    }

/*    public int getIntInput(){

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
    }*/
}
