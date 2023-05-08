import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
	    final String username = "postgres";
	    final String password = "root";
		
		//BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\NucsoftTraining\\Java\\Assignment_6\\log.txt", true));
		
		List<Employee> employees = new ArrayList<>();
		
		 Employee employee1 = new Employee(1, "John Doe", 30, "john.doe@example.com", "1234567890");
	     Employee employee2 = new Employee(2, "Jane Smith", 35, "jane.smith@example.com", "9182734560");
	     Employee employee3 = new Employee(3, "Bob Johnson", 28, "bob.johnson@example.com", "1928374560");

	        employees.add(employee1);
	        employees.add(employee2);
	        employees.add(employee3);

	        // Printing the list of employees
	        for (Employee employee : employees) {
	        	
	        	boolean errorForEmployee = false;
	        	
	        	if (employee.getContact().length() != 10)
	        		
	        	{
	        		try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\\\NucsoftTraining\\\\Java\\\\Assignment_6\\\\log.txt", true))) {
	                    writer.write("Contact should be 10 digits for empID: "+ String.valueOf(employee.getId()));
	                    writer.newLine();
	                } catch (IOException e) {
	                    System.out.println("Error logging the error message to the file.");
	                    e.printStackTrace();
	                }
	        		
	        		errorForEmployee =true;
	        	}
	        	
	        	if( (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",employee.getEmailId() )))
	        	{
	        		try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\\\NucsoftTraining\\\\Java\\\\Assignment_6\\\\log.txt", true))) {
	                    writer.write("Invalid email id for empID: "+ String.valueOf(employee.getId()));
	                    writer.newLine();
	                } catch (IOException e) {
	                    System.out.println("Error logging the error message to the file.");
	                    e.printStackTrace();
	                }
	        		
	        		errorForEmployee =true;
	        	}
	        	
	        	if(employee.getAge() <=0)
	        	{
	        		try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\\\NucsoftTraining\\\\Java\\\\Assignment_6\\\\log.txt", true))) {
	                    writer.write("Age should be a positive number for empID: "+ String.valueOf(employee.getId()));
	                    writer.newLine();
	                } catch (IOException e) {
	                    System.out.println("Error logging the error message to the file.");
	                    e.printStackTrace();
	                }
	        		
	        		errorForEmployee =true;
	        		
	        	}
	        	
	        	if(errorForEmployee==false)
	        	{
	        		//database connection logic
	        		
	        		try {
	                    // Load the PostgreSQL JDBC driver
	                    Class.forName("org.postgresql.Driver");

	                    // Create a connection to the database
	                    Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

	                    // Create the SQL INSERT statement with placeholders
	                    String sql = "INSERT INTO employees (id, name, age, email, contact) VALUES (?, ?, ?, ?, ?)";

	                    // Prepare the SQL statement
	                    PreparedStatement statement = connection.prepareStatement(sql);

	                    // Set the variable values in the prepared statement
	                    statement.setLong(1, employee.getId());
	                    statement.setString(2, employee.getName());
	                    statement.setInt(3, employee.getAge());
	                    statement.setString(4, employee.getEmailId());
	                    statement.setString(5, employee.getContact());

	                    // Execute the SQL statement
	                    int rowsAffected = statement.executeUpdate();
	                    System.out.println("Inserted " + rowsAffected + " row(s) into the database.");

	                    // Close the statement and connection
	                    statement.close();
	                    connection.close();
	                } catch (ClassNotFoundException e) {
	                    System.out.println("PostgreSQL JDBC driver not found.");
	                    e.printStackTrace();
	                } catch (SQLException e) {
	                    System.out.println("Error connecting to the database or executing the SQL statement.");
	                    e.printStackTrace();
	                }
	        	}
	        	
	        	
	        	
	        	
	        	
	            System.out.println(employee.getId());
	            System.out.println(employee.getName());
	            System.out.println(employee.getAge());
	            System.out.println(employee.getEmailId());
	            System.out.println(employee.getContact());
	            System.out.println("----------------------------------------");
	        }
	    
		
		// TODO Auto-generated method stub
		

	}

}
