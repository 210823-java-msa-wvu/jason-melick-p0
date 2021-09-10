package repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.User;

import static models.utils.ConnectionUtil.getConnectionUtil;
import java.sql.Connection;
import models.Acct;

// userId, firstName, lastName, email, phNum, ssn, dob, userName, password, fico


public class Daouser{

    // pull user's name and password for logging in
    // User user = new User();
    public User getByUserName(String username){

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "SELECT * from users where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setPhNum(rs.getInt("phone"));
                u.setSsn(rs.getString("ssn"));
                u.setDob(rs.getDate("dob"));
                u.setPassword(rs.getString("password"));
                u.setFico(rs.getInt("fico"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    /*public static void main(String[] args) {
    Daouser test = new Daouser();
    String username = "testun1!";
    //String pass = "testpass1!";

    System.out.println(test.getUserCredentials(username));
    }*/
      /*if(pass.equals(creds.(0)){
            String first = (creds);
            String last = creds.get(1).toString();
            String ID = String.valueOf(creds.get(3));
            System.out.println("Welcome " + first + " " + last + "!\n" +
                    "Login successful." + "\n" +
                    "User ID: " + ID);
        }




    }*/



}

