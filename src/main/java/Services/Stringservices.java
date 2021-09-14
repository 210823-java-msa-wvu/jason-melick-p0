package Services;

import Exceptions.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Stringservices {

    public boolean isValidUnPass(String str) throws InvalidInputException{

        if (str.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$])[a-zA-Z0-9!@#$]+$")) {

            return true;

        } else {

            throw new InvalidInputException("Not a valid username/password. Please try again.");

        }
    }

    public boolean isValidPh(String  phone) throws InvalidInputException{

        String str = String.valueOf(phone);

        if (str.matches("(^[0-9]+)") && str.length() == 10){

            return true;

        } else {

            throw new InvalidInputException("Not a valid phone number. Please try again.");
        }
    }

    public boolean isLetter(String  letter) {

        String str = String.valueOf(letter);

        if (str.matches("(^[A-Za-z]+)") && str.length() == 1){

            return true;
        }
        return false;
    }

    public boolean isName(String name) {

        if (name.matches("(^[A-Za-z-]+)")) {

            return true;
        }
        return false;
    }

    public boolean isEmail(String in){

        if (in.matches("(^[a-zA-Z0-9!@#$.]+)")){

            return true;
        }
        System.out.println("Not a valid email address. Please try again");
        return false;
    }

    public String getStrInput() {
        Stringservices ss = new Stringservices();
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        String input = "*";

        while (!valid) {

            try {

                String newInput = scan.nextLine();

                if (ss.isValidUnPass(newInput)) {

                    valid = true;
                    input = newInput;

                }
            } catch (InvalidInputException e) {
                System.out.println("Input not valid. Please try again.");
            }
        }
        return input;
    }

    public String getEmailInput() {
        Stringservices ss = new Stringservices();
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        String input = "*";

        while (!valid) {

            try{
                String newInput = scan.nextLine();

                if (ss.isEmail(newInput)) {

                    valid = true;
                    input = newInput;
                }
            } catch (IllegalArgumentException e){
                System.out.println("Not a valid username/password. Please try again.");
            }
        }
        return input;
    }

    public String getPhInput() {
        Stringservices ss = new Stringservices();
        String phone = "";
        long number = 0;
        Scanner scan = new Scanner(System.in);
        while (phone.length() < 13) {
            try {
                number = Long.parseLong(scan.nextLine());
                String phoneNumber = Long.toString(number);

                if (ss.isValidPh(phoneNumber)) {

                    String areaCode = phoneNumber.substring(0, 3);
                    String prefix = phoneNumber.substring(3, phoneNumber.length() - 4);
                    String lineNumber = phoneNumber.substring(phoneNumber.length() - 4);
                    phone = ("(" + areaCode + ")" + prefix + "-" + lineNumber);

                }
            } catch (NumberFormatException | InvalidInputException | StringIndexOutOfBoundsException | InputMismatchException e){
                //e.printStackTrace();
                System.out.println("Not a valid phone number. Please try again");
            }
        }
        return phone;
    }


    public String getNameInput() {

        Stringservices ss = new Stringservices();
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        String input = "*";

        while (!valid) {

            String newInput = scan.nextLine();

            if (ss.isName(newInput)) {
                valid = true;
                input = newInput;
            } else {
                System.out.println("Input contains invalid characters. Please try again.");
            }
        }
        return input;
    }

    public int assignRandomFico(){

        Random fico = new Random();
        int min = 550;
        int max = 850;

        int randFico = fico.nextInt((max - min) + 1) + min;

        return randFico;
    }
}

