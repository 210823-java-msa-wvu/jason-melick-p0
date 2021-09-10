package Services;

import models.Acct;
import models.User;
import repositories.Daoacct;
import repositories.Daouser;

import java.util.Scanner;

public class Userservices {

    Daouser dao = new Daouser();
    Daoacct da = new Daoacct();
    Stringservices ss = new Stringservices();

    public boolean credPass(String username, String password){
        User u = dao.getByUserName(username);
        if(u.getPassword().equals(password)){
            return true;
        } else return false;
    }

    public User newUser(Acct a){
        boolean created = false;
        User u = new User();

        while (!created){
            System.out.println("Please enter your first name:");
            u.setFirstName(ss.getStrInput());
            System.out.println("Please enter your last name");
            u.setLastName(ss.getStrInput());
            System.out.println("Please enter your email address:");
            u.setEmail(ss.getEmailInput());
            System.out.println("Please enter your 10-digit phone number (numbers only):");
            u.setPhNum(ss.getPhInput());
            System.out.println("Please enter your date-of-birth in 'MMDDYYYY' format:");
            u.setDob(ss.getDateInput());
        }
    }

}
