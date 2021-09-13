package Services;

import Models.Acct;
import Models.User;
import Repositories.Daoacct;
import Repositories.Daouser;

public class Userservices {

    Daouser du = new Daouser();
    Daoacct da = new Daoacct();
    Stringservices ss = new Stringservices();

    public boolean credPass(String username, String password){

        User u = du.getByUserName(username);

        try {
            if(u.getPassword().equals(password)){
                return true;
            }

        } catch (NullPointerException e){
            System.out.println("Credentials do not match.");
        }
        return false;
    }

    public void newUser(Acct a){

        boolean created = false;
        User u = new User();

        while (!created){

            System.out.println("Please enter your first name:");
            u.setFirstName(ss.getNameInput());
            System.out.println("Please enter your last name");
            u.setLastName(ss.getNameInput());
            System.out.println("Please enter your email address:");
            u.setEmail(ss.getEmailInput());
            System.out.println("Please enter your 10-digit phone number (numbers only):");
            u.setPhNum(ss.getPhInput());
            System.out.println("Please enter a username. Please include only letters, digits, and !@#$" +
                    "\nMust include one uppercase one lowercase one digit and one special character:");
            u.setUserName(ss.getStrInput());
            System.out.println("Please enter a password. Please include only letters, digits, and !@#$: " +
                    "\nMust include one uppercase one lowercase one digit and one special character:");
            u.setPassword(ss.getStrInput());
            u.setSsn(a.getSsn());

            du.create(u);

            User user = du.getNewByUserName(u);
            int newId = user.getuserId();
            int accId = a.getAcctId();

            da.updateNewUserId(newId, accId);

            System.out.println("\nAccount successfully created. Proceeding to login screen.");
            created = true;
        }
    }
}
