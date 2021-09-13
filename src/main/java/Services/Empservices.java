package Services;

import Repositories.Daoemp;
import Models.Lo;

public class Empservices {

    Daoemp de = new Daoemp();

    public boolean credPass(String username, String password){

        Lo employee = de.getByUserName(username);

        try {
            if (employee.getPassword().equals(password)) {
                return true;
            }
        } catch(NullPointerException e){
            System.out.println("Credentials do not match.");
        }
        return false;
    }

}
