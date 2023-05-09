package assignment_7.CRUD_Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadEmployeeData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "root";
 
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM Employee"
             );
             ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int salary = rs.getInt("salary");
                String city = rs.getString("city");
                String phone = rs.getString("phone");
                String email = rs.getString("emailid");
                
                System.out.println("Employee ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Salary: " + salary);
                System.out.println("City: " + city);
                System.out.println("Phone: " + phone);
                System.out.println("Email: " + email);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

