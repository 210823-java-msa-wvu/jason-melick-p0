package dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.User;
import models.utils.ConnectionUtil;
import models.utils.ConnectionUtil;
import static models.utils.ConnectionUtil.getConnectionUtil;
import java.sql.Connection;
import java.util.List;

import static models.utils.ConnectionUtil.getConnectionUtil;


public class Daouser{

    // pull user's name and password for logging in
    public List<User> getUserCredentials(String username){

        List<User> credentials = new ArrayList<>();

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "SELECT first_name, last_name, password, user_id from users where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                credentials.add(
                        new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credentials;
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

    public static void main(String[] args){
        Daouser test = new Daouser();
        String username = "testun1!";
        String pass = "testpass1!";
        List<User> creds = test.getUserCredentials(username);
        System.out.println(creds);
      /* if(pass.equals(creds.(0)){
            String first = (creds);
            String last = creds.get(1).toString();
            String ID = String.valueOf(creds.get(3));
            System.out.println("Welcome " + first + " " + last + "!\n" +
                    "Login successful." + "\n" +
                    "User ID: " + ID);
        }*/




    }



}

