package assignment_7.CRUD_Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployeeRecord {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "root";
 
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE Employee SET name=?, age=?, salary=?, city=?, phone=?, emailid=? WHERE id=?"
             )
        ) {
            stmt.setString(1, "Jane Doe"); // set the new value for the name column
            stmt.setInt(2, 35); // set the new value for the age column
            stmt.setInt(3, 60000); // set the new value for the salary column
            stmt.setString(4, "Los Angeles"); // set the new value for the city column
            stmt.setString(5, "9876543210"); // set the new value for the phone column
            stmt.setString(6, "jane.doe@example.com"); // set the new value for the emailid column
            stmt.setInt(7, 1); // specify which record to update based on the id column
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

