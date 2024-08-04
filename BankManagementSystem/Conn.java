package BankingApp;
import java.sql.*;

public class Conn {
	Connection c;
	
	public Conn() {
        try {
            // Loading the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establishing the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementSystem", "root", "Ak,3f.p8@&!wE");
            System.out.println("Connection Successfully Established");
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to establish a database connection.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}

