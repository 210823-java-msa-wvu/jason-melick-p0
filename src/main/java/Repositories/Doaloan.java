package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Models.utils.ConnectionUtil.getConnectionUtil;

import Models.Loan;
import Models.User;

public class Doaloan {

    public void createLoan(Integer amt, User u){

        try(Connection connection = getConnectionUtil().getConnection()){

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

    public ArrayList<Loan> getAllByStatus (String status){

        try(Connection connection = getConnectionUtil().getConnection()){

            ArrayList<Loan> loans = new ArrayList<>();

            String sql = "SELECT * from loans where status = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();


            // Integer acctId, String ssn, Integer bal, String flag
            while(rs.next()){
                Loan loan = new Loan();
                loan.setLoanId(rs.getInt("loan_id"));
                loan.setUserId(rs.getInt("user_id"));
                loan.setLoanAmt(rs.getInt("loan_amt"));
                loans.add(loan);
            }
            return loans;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Loan getById (int id){

        try(Connection connection = getConnectionUtil().getConnection()){

            Loan loan = new Loan();

            String sql = "SELECT * from loans where loan_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();


            // Integer acctId, String ssn, Integer bal, String flag
            if(rs.next()){
                loan.setLoanId(rs.getInt("loan_id"));
                loan.setUserId(rs.getInt("user_id"));
                loan.setLoanAmt(rs.getInt("loan_amt"));
                //loan.getStatus(rs.getString("status"));

            }
            return loan;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateStatus(Integer empId, Integer loanId, Loan loan){

        try(Connection connection = getConnectionUtil().getConnection()){
            //System.out.println(a);
            String sql = "UPDATE loans SET status = ?, app_by = ? WHERE loan_id = ?";
            //System.out.println("TEST Daoloan updateStatus" + empId +"  " );
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, loan.getStatus());
            ps.setInt(2, empId);
            ps.setInt(3, loanId);

            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }


    }

/*   public static void main(String[] args){
        Doaloan dl = new Doaloan();
        ArrayList<Loan> theseLoans = dl.getAllByStatus("pending");
        theseLoans.forEach(System.out::println);
    }*/

}
