package Repositories;

import Models.Acct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Models.utils.ConnectionUtil.getConnectionUtil;

public class Daoacct {

    public Acct getAcctById(Integer userid){

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "SELECT * from accounts where user_id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Acct a = new Acct();

                a.setAcctId(rs.getInt("acc_id"));
                a.setSsn(rs.getString("ssn"));
                a.setBal(rs.getInt("bal"));
                a.setFlag(rs.getString("flag"));

                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Acct getAcctBySsn(String ssn){

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "SELECT * from accounts where ssn = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ssn);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Acct a = new Acct();

                a.setAcctId(rs.getInt("acc_id"));
                a.setSsn(rs.getString("ssn"));
                a.setBal(rs.getInt("bal"));
                a.setFlag(rs.getString("flag"));
                a.setUserId(rs.getInt("user_id"));

                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateAcct(Acct a){

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "UPDATE accounts SET bal=?, flag=? WHERE acc_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, a.getBal());
            ps.setString(2, a.getFlag());
            ps.setInt(3, a.getAcctId());

            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNewUserId(Integer newUserId, Integer accId){

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "UPDATE accounts SET user_id=? WHERE acc_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, newUserId);
            ps.setInt(2, accId);

            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

