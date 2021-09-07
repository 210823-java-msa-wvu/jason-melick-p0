package models;

import java.math.BigDecimal;
import java.util.Date;

public class Trans {

    Integer transId; // each transaction will have a serial id
    Date date; //the business day of the transaction
    String accType; // the type of account the transaction will post to "Primary" or "Loan"
    Integer acctNum; // the number of the account the transaction posts to
    Integer userId; // the sql user_id of the account holder
    BigDecimal amt; // the amount of the transaction. should be appropriately formatted and exact
    BigDecimal startBal; // the balance at the time of the transaction
    BigDecimal endBal; // the balance after the transaction posts

    // constructors
    public Trans (){}

    public Trans(Integer transId, Date date, Integer acctNum, Integer userId, BigDecimal amt, BigDecimal startBal, BigDecimal endBal){
        this.transId = transId;
        this.date = date;
        this.acctNum = acctNum;
        this.userId = userId;
        this.amt = amt;
        this.startBal = startBal;
        this.endBal = endBal;
    }

    // GETTERS AND SETTERS
    // transId Integer
    public Integer gettransId(){
        return this.transId;
    }
    public void settransId(Integer transId){
        this.transId = transId;
    }
    
    // date Date
    public Date getDate(){
        return this.date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    
    // acctNum Integer
    public Integer getAcctNum(){
        return this.acctNum;
    }
    public void setAcctNum(Integer acctNum) {
        this.acctNum = acctNum;
    }

    // accType String
    public String getAccType(){
        return this.accType;
    }
    public void setAccType(String accType){
        this.accType = accType;
    }
    
    // userId Integer
    public Integer getUserId(){
        return this.userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
    
    // amt BigDecimal
    public BigDecimal getAmt(){
        return this.amt;
    }
    public void setAmt(BigDecimal amt){
        this.amt = amt;
    }
    
    // startBal BigDecimal
    public BigDecimal getStartBal(){
        return this.startBal;
    }
    public void setStartBal(BigDecimal startBal){
        this.startBal = startBal;
    }
    
    // endBal BigDecimal
    public BigDecimal getEndBal(){
        return  this.endBal;
    }
    public void setEndBal(BigDecimal endBal){
        this.endBal = endBal;
    }

}

