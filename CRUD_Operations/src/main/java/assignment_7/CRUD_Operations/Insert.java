package assignment_7.CRUD_Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) {
    	final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
	    final String username = "postgres";
	    final String password = "root";
 
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Employee (id, name, age, salary, city, phone, emailid) VALUES (?, ?, ?, ?, ?, ?, ?)"
             )
        ) {
            stmt.setInt(1, 3); // set the value for the first parameter (id) to 1
            stmt.setString(2, "John Doe"); // set the value for the second parameter (name) to "John Doe"
            stmt.setInt(3, 30); // set the value for the third parameter (age) to 30
            stmt.setInt(4, 50000); // set the value for the fourth parameter (salary) to 50000
            stmt.setString(5, "New York"); // set the value for the fifth parameter (city) to "New York"
            stmt.setString(6, "1234567890"); // set the value for the sixth parameter (phone) to "1234567890"
            stmt.setString(7, "john.doe@example.com"); // set the value for the seventh parameter (emailid) to "john.doe@example.com"
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
