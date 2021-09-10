package repositories;

import models.Acct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static models.utils.ConnectionUtil.getConnectionUtil;

import models.Loan;
import models.User;

public class Doaloan {

    public void createLoan(Integer amt, User u){

        try(Connection connection = getConnectionUtil().getConnection()){
            //System.out.println(amt);
            //System.out.println(u);
            String sql = "INSERT INTO loans (user_id, loan_amt, status) VALUES (?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, u.getuserId());
            ps.setInt(2, amt);
            ps.setString(3, "pending");

            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }


    }


}
