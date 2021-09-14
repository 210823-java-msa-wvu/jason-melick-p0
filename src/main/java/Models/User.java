package Models;

import java.util.Date;

public class User {
    // initialize variables corresponding to the fields in the user_data table in DB
    // make them private, so they can't be accessed outside the class without getters and setters
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phNum;
    private String ssn;
    private Date dob;
    private String userName;
    private String password;
    private Integer fico;

    // default no args constructor
    public User(){

    }

    // for Loan Officer queries
    public User (Integer userId, String firstName, String lastName, Integer fico){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fico = fico;
    }

    // constructor used for login/logout
    public User (String firstName, String lastName, String password, Integer userId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userId = userId;
    }

    // constructor for new account creation, or superUser query/modification
    public User (Integer userId, String firstName, String lastName, String email, String phNum, String ssn, Date dob, String userName, String password, Integer fico){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phNum = phNum;
        this.ssn = ssn;
        this.dob = dob;
        this.userName = userName;
        this.password = password;
        this.fico = fico;
    }

    // create getter and setter methods for passing information to/from the console
    // these methods should be public and non-static, so they can be called by other classes
    // getters are expected to return data, so should have a return type matching the instance variable type
    // setters do not return anything, so should have a void return type

    // customer ID
    public Integer getuserId() {
        return this.userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }

    // first name
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    // last name
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //email String
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    //phNum Integer
    public String getPhNum(){
        return this.phNum;
    }
    public void setPhNum(String phNum){
        this.phNum = phNum;
    }

    // SSN
    public String getSsn() {
        return this.ssn;
    }
    public void setSsn(String ssn){
        this.ssn = ssn;
    }

    // DOB
    public Date getDob(){
        return this.dob;
    }
    public void setDob(Date dob){
        this.dob = dob;
    }

    // Username
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    // Password
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    // FICO Score
    public Integer getFico() {
        return this.fico;
    }
    public void setFico(Integer fico){
        this.fico = fico;
    }

    // override toString() method for this class
    @Override
    public String toString(){
        return firstName + " " + lastName + "\n" +
                "Password: " + password + "\n" + "userid" + userId;
    }

}
