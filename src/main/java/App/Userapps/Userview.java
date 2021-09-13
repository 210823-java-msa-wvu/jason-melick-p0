package App.Userapps;

import Services.Acctservices;
import Models.User;
import Models.Acct;
import Repositories.Daoacct;
import Repositories.Doaloan;

import java.util.Scanner;

public class Userview {

    public void userView(User user) {

        Userview uv = new Userview();
        Daoacct da = new Daoacct();
        Doaloan dl = new Doaloan();
        Acctservices as = new Acctservices();

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
                    int amt = uv.getAmtInput();
                    as.deposit(acct, amt);
                    break;
                }

                case 3: {
                    System.out.println("\nMake a withdrawal ");
                    int amt = uv.getAmtInput();
                    as.withdrawal(acct, amt);
                    break;
                }

                case 4: {
                    System.out.println("\nApply for a loan ");
                    int amt = uv.getAmtInput();
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

    public int getIntInput(){

        int selection = -1;
        while (selection < 0 || selection > 5){
            Scanner scan = new Scanner(System.in);
            try{
                System.out.println("Please enter your choice:");
                selection = Integer.parseInt(scan.nextLine());
            }
            catch (NumberFormatException e){
                //e.printStackTrace();
                System.out.println("Invalid selection. Please try again:");
            }
        }
        return selection;
    }

    public int getAmtInput(){
        Scanner scan = new Scanner(System.in);
        int amt = 0;

        while (amt <= 0) {

            try{
                System.out.println("Enter amount:");
                amt = scan.nextInt();

            }catch (NumberFormatException e){
                //e.printStackTrace();
                System.out.println("Amount not valid. Please try again");
            }
        }
        return amt;
    }

}

