package models;

import java.math.BigDecimal;

public class Acct {

    // there will be an accounts table in sql that holds only the basic information about the account
    // the transaction ledger will be a separate table
    // each customer *may* have their own account ledger table depending on time

    private Integer acctId; // account ID will correspond to record number in database
    private Integer acctNum; // account number should be not null, unique primary key, must be 10 digits with no leading zeros
    private Integer bal;  // user's current balance
    private String ssn;
    private boolean isOverdrawn; // will let us know if the customer's balance is negative
    private String flag; // will be "N" if user's account is not overdrawn. "Y" if they have a negative balance
    private Integer userId; // customer ID field should match same column in User table (foreign key)

    // create constructors to match various use cases
    public Acct(){

    }

    // for querying the account in the user view or LO views
    public Acct(Integer acctId, String ssn, Integer bal, String flag){
        this.acctId = acctId;
        this.ssn = ssn;
        this.bal = bal;
        this.flag = flag;
    }

    // for SQL handling
    public Acct(Integer custId, Integer acctId, Integer acctNum, Integer bal, boolean isOverdrawn, String flag){
        this.userId = userId;
        this.acctId = acctId;
        this.acctNum = acctNum;
        this.bal = bal;
        this.isOverdrawn = isOverdrawn;
        this.flag = flag;
    }

    // getters and setters
    // userId Integer
    public Integer getUserId(){
        return this.userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }

    // acctID Integer
    public Integer getAcctId(){
        return this.acctId;
    }
    public void setAcctId(Integer acctId){
        this.acctId = acctId;
    }

    // acctNum Integer
    public Integer getAcctNum(){
        return this.acctNum;
    }
    public void setAcctNum(Integer acctNum){
        this.acctNum = acctNum;
    }

    // bal BigDecimal
    public Integer getBal(){
        return this.bal;
    }
    public void setBal(int bal){
        this.bal = bal;
    }

    // ssn String
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    // isOverdrawn boolean
    public boolean getIsOverdrawn(){
        return this.isOverdrawn;
    }
    public void setIsOverdrawn(boolean isOverdrawn){
        this.isOverdrawn = isOverdrawn;
    }

    // flag String
    public String getFlag(){
        return this.flag;
    }
    public void setFlag(String flag){
        this.flag = flag;
    }

    // override toString() method
    @Override
    public String toString(){
       return  "Account ID: " + acctId + "\n" +
               "Social Security Number: " + ssn+ "\n" +
               "Balance: " + bal + "\n" +
               "Currently Overdrawn? " + flag;
    }

}
