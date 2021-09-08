package Services;

import models.User;
import repositories.Daouser;

public class Userservices {

    public boolean credPass(String username, String password){
        Daouser dao = new Daouser();
        User u = dao.getUserCredentials(username);
        if(u.getPassword().equals(password)){
            return true;
        } else return false;
    }

    public static void main(String[]args){
        Userservices us = new Userservices();
        Daouser dao = new Daouser();
        String un = "testun1!";
        String pass = "testpass1!";
        User u = dao.getUserCredentials(un);
        System.out.println(u.getPassword());
        System.out.println(u);
        System.out.println(us.credPass(un, pass));
    }
}
