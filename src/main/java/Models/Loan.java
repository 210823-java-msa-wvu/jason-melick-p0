package Models;

import java.util.Date;


public class Loan {

    Integer loanId; // loan serial number
    Integer userId; // the customer's user serial from users table in DB
    Integer loanAmt; // original loan principal
    // BigDecimal monthly; // monthly payment amount
    // BigDecimal pmt; // amount paid this month default 0 in sql
    // BigDecimal startBal; // balance at the start of the period
    // BigDecimal endBal; // startbal minus any payments
    Date appDate; // date the loan was approved
    Integer appBy; // employee ID of the approving loan officer
    String status; // "Pending, Approved, Denied, Current, or Flag"

    // constructors
    public Loan(){}

    // for creating a new loan
    public Loan(Integer userId, Integer loanAmt, String status){
        // this.loanId = loanId;
        this.userId = userId;
        this.loanAmt = loanAmt;
        // this.monthly = monthly;
        // this.pmt = pmt;
        // this.startBal = startBal;
        // this.endBal = endBal;
        //this.appDate = appDate;
        //this.appBy = appBy;
        this.status = status;
    }

    //GETTERS AND SETTERS
    // loanId Integer
    public Integer getLoanId(){
        return this.loanId;
    }
    public void setLoanId(Integer loanId){
        this.loanId = loanId;
    }

    // userId Integer
    public Integer getUserId(){
        return this.userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }

    // loanAmt BigDecimal
    public Integer getLoanAmt(){
        return this.loanAmt;
    }
    public void setLoanAmt(Integer loanAmt){
        this.loanAmt = loanAmt;
    }

    // appDate date
    public Date getAppDate(){
        return this.appDate;
    }
    public void setAppDate(Date appDate){
        this.appDate = appDate;
    }

    // appBy Integer
    public Integer getAppBy(){
        return this.appBy;
    }
    public void setAppBy(Integer appBy){
        this.appBy = appBy;
    }

    // status String
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    // override toString method
    @Override
    public String toString(){
        return  "Loan ID: " + loanId + "  User ID: " + userId + "  Amount: $ " + loanAmt;
                //"Status: " + status;
    }

}
