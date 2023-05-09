package assignment_7.CRUD_Operations;

import java.sql.*;
 
/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * @author www.codejava.net
 *
 */
public class JdbcSQLServerConnection {
 
    public static void main(String[] args) {
 
        /*Connection conn = null;
        PreparedStatement stmt = null;*/
        
        String dbURL = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "root";
 
        try (Connection conn = DriverManager.getConnection(dbURL, user, pass);
                PreparedStatement stmt = conn.prepareStatement(
                        "CREATE TABLE Employee (" +
                                "id INT PRIMARY KEY," +
                                "name VARCHAR(25)," +
                                "age INT," +
                                "salary INT," +
                                "city VARCHAR(25)," +
                                "phone VARCHAR(10)," +
                                "emailid VARCHAR(25)" +
                                ")"
                )
           ) {
               stmt.executeUpdate();
               System.out.println("Employee table created successfully!");
           } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
}
