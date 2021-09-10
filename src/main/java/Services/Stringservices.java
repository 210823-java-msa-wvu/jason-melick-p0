package Services;

import java.util.Date;
import java.util.Scanner;

public class Stringservices {

    public boolean isValidUnPass(String str) {

        if (str.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$])[a-zA-Z0-9!@#$]+$")) {
            //System.out.println("first statement true");

            return true;
        }
        return false;
    }

    public boolean isValidPh(Integer phone) {
        String str = String.valueOf(phone);

        if (str.matches("(^[0-9])") || str.length() != 10){
        return false;
        }
        return true;
    }

    public boolean isValidDate(Integer intdate) {
        String str = String.valueOf(intdate);

        if (str.matches("(^[0-9])") || str.length() != 8){
            return false;
        }
        return true;
    }

    public boolean isEmail(String str) {

        if (str.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@.])[a-zA-Z0-9@.]+$")) {
            //System.out.println("first statement true");

            return true;
        }
        return false;
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

    public String getEmailInput() {
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

    public int getPhInput() {
        boolean isValid = false;
        int input  = -1;
        while (input < 2 && String.valueOf(input).length() < 10 && isValid == false) {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Please enter your choice:");
                input = Integer.parseInt(scan.nextLine());
                isValid = isValidPh(input);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Invalid selection. Please try again:");
            }
        }
        return input;
    }

    public Date getDateInput() {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        String date = "";
        boolean goodDate= false;
        while (!goodDate && String.valueOf(input).length() < 8 && input < 19000000) {
            try {
                input = scan.nextInt();
                //System.out.println("input: " + input);
                String strDate = String.valueOf(input);
                //System.out.println("soc: " + soc);
                date = date + strDate.substring(0, 4) + "-" + strDate.substring(4, 6) + "-" + strDate.substring(6);
                //System.out.println("ssn inside getSsn: " + ssn);
                goodDate= true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                //System.out.println("Not a valid ssn. Please try again");
            }
        }
        //scan.close();
        return Date.parse(date);
    }




    //public String nameConditioner()


/*    public static void main(String[] args) {
        Stringservices ss = new Stringservices();
        String badinput = "T^&*(^('hj";
        System.out.println(ss.isValidChars(badinput));
    }*/

/*    public static void main(String[] args){
        Stringservices ss = new Stringservices();
        int orig = 12345678;
        String date = "";
        String strDate = String.valueOf(orig);
        //System.out.println("soc: " + soc);
        date = date + strDate.substring(0, 4) + "-" + strDate.substring(4, 6) + "-" + strDate.substring(6);
        System.out.println(date);
    }*/
}