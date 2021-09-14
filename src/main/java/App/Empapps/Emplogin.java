package App.Empapps;

import Exceptions.InvalidInputException;
import Models.Lo;
        import Repositories.Daoemp;
        import Services.Empservices;

import java.util.Scanner;
import Services.Stringservices;

public class Emplogin {

    public void loginView() throws InvalidInputException {

        Emplogin el = new Emplogin();
        Daoemp de = new Daoemp();
        Empview ev = new Empview();
        Empservices es = new Empservices();

        boolean running = true;

        while (running) {
            boolean logged = false;

            while (!logged) {

                System.out.println("Please enter your username and press Enter:");
                String uname = el.getStrInput();

                System.out.println("Please enter your password and press Enter:");
                String pass = el.getStrInput();

                if (es.credPass(uname, pass) == true) {

                    Lo employee = de.getByUserName(uname);

                    System.out.println("\nHello " + employee.getFirstName() + " " + employee.getLastName());

                    ev.empView(employee);
                    running = false;
                    logged = true;

                    } else {
                        System.out.println("Your username or password do not match our records. Please try again.");
                    }
                }
            }
        }

    public String getStrInput() throws InvalidInputException {
        Stringservices ss = new Stringservices();
        Scanner scan = new Scanner(System.in);
        //scan.close();
        boolean valid = false;
        String input = "*";
        while (!valid) {

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
