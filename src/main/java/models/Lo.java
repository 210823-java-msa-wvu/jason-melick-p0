package models;

public class Lo {

    private Integer empId; // not null, primary key, unique
    private String firstName; // only alphabetic, apostrophe, hyphen, and spaces.
    private String lastName; // same rules as firstName
    private String email; // only lower-case, and shifted number characters plus _- limit 30 caracters must end in mybank.com
    private String phNum; // modified to 10-digit string of numbers
    private String userName; //case-sensitive, unique, not null, 8-12 alpha-numeric characters. can include underscores or all symbols from shift+ 0-9. no apostrophes, equals, or forward slash
    private String password; //case-sensitive, unique, not null, 8-12 alpha-numeric characters. can include underscores or all symbols from shift+ 0-9. no apostrophes, equals, or forward slash
    // must not contain 'pass', 'password', or any characters that repeat 4 or more times
    private String ssn; //will be handled as a string in format "XXX-XX-XXXX"
    private String dob; //will be handled as a string "MM/DD/YYYY" at the application/presentation layers
    //handled as a string "YYYY/MM/DD" by the Data layer

    // create constructors for the LoanOfficer class for various use cases
    // should be public, so they can be used by methods outside the class

    // default no-args constructor
    public Lo(){

    }

    // constructor for logins
    public Lo(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    // all args constructor
    public Lo(Integer empId, String firstName, String lastName, String userName, String password, String ssn, String dob){
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.ssn = ssn;
        this.dob = dob;
    }

    // getter and setter methods for each private instance variable. getters should have the correct return type. setters should be void as they don't return anything

    // empId
    public Integer getEmpId(){
        return this.empId;
    }
    public void setEmpId(Integer empId){
        this.empId = empId;
    }

    // firstName
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    // lastName
    public String getLastName(){
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

    // userName
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    // password
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    // ssn
    public String getSsn(){
        return this.ssn;
    }
    public void setSsn(String ssn){
        this.ssn = ssn;
    }

    // dob
    public String getDob(){
        return this.dob;
    }
    public void setDob(String dob){
        this.dob = dob;
    }

    // we do not want the memory address to print out when referring to an object of this class
    // we must override the toString() method to display the information we want
    @Override
    public String toString(){
        return "Employee Name: " + firstName + " " + lastName + "\n" +
        "Employee ID: " + empId;
    }

}
