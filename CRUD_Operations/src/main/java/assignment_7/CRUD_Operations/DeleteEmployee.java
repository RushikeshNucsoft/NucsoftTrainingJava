package assignment_7.CRUD_Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "root";
 
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(
                     "DELETE FROM Employee WHERE id=?"
             )
        ) {
            stmt.setInt(1, 1); // specify which record to delete based on the id column
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
