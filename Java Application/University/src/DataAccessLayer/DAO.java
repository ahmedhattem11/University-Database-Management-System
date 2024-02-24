/*package DataAccessLayer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521/XE";
    private static final String USERNAME = "CASESTUDY";
    private static final String PASSWORD = "123";
    private static Connection con;

    // Private constructor to prevent direct instantiation
    private DAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error establishing database connection", ex);
            System.exit(1);
        }
    }

    // Static method to get the database connection
    public static synchronized Connection getConnection() {
        if (con == null) {
            System.out.println("error");
            new DAO(); // Create a new instance if not already created
        }
        return con;
    }

    // Close the database connection
    public static synchronized void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                con = null;
            }
            System.out.println("close cone");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error closing database connection", ex);
        }
    }
}*/



/*package DataAccessLayer;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    private static DAO instance; // Singleton instance
    private static Connection con;
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USERNAME = "CASESTUDY";
    private static final String PASSWORD = "123";
    
    
    private DAO(){//make the constructor private for the enforce just there is one object from this class to apply the singleton design pattern
    try {
        con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    } catch (SQLException ex) {
        Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Error establishing database connection", ex);
        System.exit(1);
    } 
}


    public static Connection getConnection() {
        return con;
    }
    
    public static DAO getInstance() {//instansation method for signleton object
        if (instance == null) {
            instance = new DAO();
        }
        return instance;
    }
    
    public void getMetaData() throws SQLException{
        DatabaseMetaData metaData = con.getMetaData();

        // Retrieve database information
        System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
        System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
        System.out.println("Driver Name: " + metaData.getDriverName());
        System.out.println("Driver Version: " + metaData.getDriverVersion());
        System.out.println("schema: " +metaData.getConnection().getCatalog());
    }
     
    public static void closeConnection() throws SQLException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                con = null;
                instance = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}*/

package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    // Method to establish a connection to the database
    public static Connection getConnection() {
        Connection connect = null;
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establish the connection using the provided database URL, username, and password
            connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "CASESTUDY", "123");
        } catch (ClassNotFoundException | SQLException e) {
            // Log any exceptions encountered during connection establishment
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Failed to establish database connection", e);
        }
        // Return the established connection
        return connect;
    }
}

