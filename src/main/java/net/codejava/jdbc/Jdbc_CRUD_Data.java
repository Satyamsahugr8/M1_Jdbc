package net.codejava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_CRUD_Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Primary data needed to estable the connection
		Connection conn = null;
 
        try {
            // Connect method #1
            String dbURL1 = "jdbc:postgresql:Demo?user=postgres&password=qwer1234";
            String dbURL2 = "jdbc:postgresql://localhost:5432/Demo";String user = "postgres";String password="qwer1234";
//            conn = DriverManager.getConnection(dbURL1);
            conn = DriverManager.getConnection(dbURL2,user,password);
            if (conn != null) {
                System.out.println("Connected to database");
            }
            
            
            
            // Inserting
            
            
//            String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
//            
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, "bill3");
//            statement.setString(2, "secretpassssss");
//            statement.setString(3, "Bill Gates");
//            statement.setString(4, "bill.gates3@microsoft.com");
//             
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("A new user was inserted successfully!");
//            }
            
            
            // Fetching
            
            
            String sql = "SELECT * FROM Users";
            
            Statement statement2 = conn.createStatement();
            ResultSet result = statement2.executeQuery(sql);
             
            int count = 0;
             
            while (result.next()){
                String name = result.getString(2);
                String pass = result.getString(3);
                String fullname = result.getString("fullname");
                String email = result.getString("email");
             
                String output = "User #%d: %s - %s - %s - %s";
                System.out.println(String.format(output, ++count, name, pass, fullname, email));
            }
            
            
            
            // Updating 
            
//            String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
//            
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, "123456789");
//            statement.setString(2, "William Henry Bill Gates");
//            statement.setString(3, "bill.gates22@microsoft.com");
//            statement.setString(4, "bill2");
//             
//            int rowsUpdated = statement.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("An existing user was updated successfully!");
//            }
            
            
            // Deleting
            
//            String sql = "DELETE FROM Users WHERE username=?";
//            
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, "bill3");
//             
//            int rowsDeleted = statement.executeUpdate();
//            if (rowsDeleted > 0) {
//                System.out.println("A user was deleted successfully!");
//            }
            
            
            
            
            
            
            
       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           try {
               if (conn != null && !conn.isClosed()) {
                   conn.close();
               }
           } catch (SQLException ex) {
               ex.printStackTrace();
               }
           }
        }
}
