package repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.User;

import static models.utils.ConnectionUtil.getConnectionUtil;
import java.sql.Connection;


public class Daouser{

    // pull user's name and password for logging in
    // User user = new User();
    public User getUserCredentials(String username){

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "SELECT * from users where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User();
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setPassword(rs.getString("password"));
                u.setuserId(rs.getInt("user_id"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // to view user accounts
/*    public List<User> getUserAccount(Integer userId){

        List<User> account = new ArrayList<>();

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "SELECT * FROM accounts WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                   account.add
                           new User(rs.getString(1));
            }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return account;
    }*/

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

