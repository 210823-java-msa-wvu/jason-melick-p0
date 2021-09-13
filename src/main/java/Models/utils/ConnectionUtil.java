package Models.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static ConnectionUtil cu = null;
    private static Properties props;

    private ConnectionUtil(){
        props = new Properties();

        // need a way to capture data from properties file
        InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");

        // try stream capture inside try/catch block to catch possible IOException
        try{
            // capturing properties from connection.properties from stream
            props.load(dbProps);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Problem encountered capturing DB properties from connection.properties");
        }
    }

    // method to establish connection to AWS DB
    // check for existing connection first
    // if none present, create a new instance of the ConnectionUtil object called 'cu'
    public static ConnectionUtil getConnectionUtil(){
        if(cu == null){
            // is there an existing connection? If not, create a new one.
            cu = new ConnectionUtil();
        }
        // if there is an established connection, return it instead
        return cu;
    }

    public Connection getConnection() {
        // clear any possible existing connection data
        Connection conn = null;

        // get needed credentials from the connection.properties file
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        // the connection will be passing SQL statements, so we need to catch possible SQL exceptions
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception encountered while establishing DB connection.");
        }
        return conn;
    }

    /*public static void main(String[] args){

        Connection connection = getConnectionUtil().getConnection();

        // check for successful connection
        if(connection != null){
            System.out.println("DB connection successful.");
        }else{
            System.out.println("The attempt to establish a DB was unsuccessful.");
        }
    }*/
}



