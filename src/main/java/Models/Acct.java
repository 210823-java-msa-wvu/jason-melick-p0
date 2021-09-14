package Models;

public class Acct {

    private Integer acctId;
    private Integer acctNum;
    private Integer bal;
    private String ssn;
    private boolean isOverdrawn;
    private String flag;
    private Integer userId;

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
