package Repositories;

import java.sql.*;

import Models.Lo;

import static Models.utils.ConnectionUtil.getConnectionUtil;
import java.sql.Connection;

public class Daoemp {

    public Lo getByUserName(String username){
        Daoemp de = new Daoemp();

        try(Connection connection = getConnectionUtil().getConnection()){

            String sql = "SELECT * from loan_officers where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Lo lo = new Lo();
                lo.setEmpId(rs.getInt("emp_id"));
                lo.setFirstName(rs.getString("first_name"));
                lo.setLastName(rs.getString("last_name"));
                lo.setEmail(rs.getString("email"));
                lo.setSsn(rs.getString("ssn"));
                lo.setPassword(rs.getString("password"));
                return lo;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
