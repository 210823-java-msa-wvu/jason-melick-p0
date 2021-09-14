package Models;

public class Lo {

    private Integer empId;
    private String firstName;
    private String lastName;
    private String email;
    private String phNum;
    private String userName;
    private String password;
    private String ssn; //will be handled as a string in format "XXX-XX-XXXX"

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

    // we do not want the memory address to print out when referring to an object of this class
    // we must override the toString() method to display the information we want
    @Override
    public String toString(){
        return "Employee Name: " + firstName + " " + lastName + "\n" +
        "Employee ID: " + empId;
    }

}
