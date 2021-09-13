package Repositories;

import java.sql.*;
import Services.Stringservices;
import Models.User;
import static Models.utils.ConnectionUtil.getConnectionUtil;
import java.sql.Connection;


public class Daouser{

    public void create(User u){

        Stringservices ss = new Stringservices();

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "INSERT INTO users (first_name, last_name, email, phone, username, password, fico, ssn) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, u.getFirstName());
            ps.setString(2, u.getLastName());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPhNum());
            ps.setString(5, u.getUserName());
            ps.setString(6, u.getPassword());
            ps.setInt(7, ss.assignRandomFico());
            ps.setString(8, u.getSsn());

            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public User getNewByUserName(User user){

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "SELECT * from users where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User();

                u.setUserId(rs.getInt("user_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setPhNum(rs.getString("phone"));
                u.setSsn(rs.getString("ssn"));
                u.setPassword(rs.getString("password"));
                u.setFico(rs.getInt("fico"));

                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

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
                u.setPhNum(rs.getString("phone"));
                u.setSsn(rs.getString("ssn"));
                u.setPassword(rs.getString("password"));
                u.setFico(rs.getInt("fico"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getById(int id){

        try(Connection connection = getConnectionUtil().getConnection()){
            String sql = "SELECT * from users where user_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User();
                //u.setUserId(rs.getInt("user_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setPhNum(rs.getString("phone"));
                u.setSsn(rs.getString("ssn"));
                u.setPassword(rs.getString("password"));
                u.setFico(rs.getInt("fico"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

