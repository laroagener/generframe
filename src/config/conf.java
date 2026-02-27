/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USER34
 */
public class conf {
    // SQLite database path - adjust this to your actual file location
    private static final String DB_URL = "jdbc:sqlite:GENER.db"; // If in project root
    // OR private static final String DB_URL = "jdbc:sqlite:C:/path/to/your/GENER.db";
    
    public Connection connectDB() {
        Connection conn = null;
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            
            // Establish connection
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("✓ SQLite Database connected successfully!");
            
        } catch (ClassNotFoundException e) {
            System.out.println("✗ SQLite JDBC Driver not found!");
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "SQLite Driver missing! Add sqlite-jdbc.jar to your project libraries.");
        } catch (SQLException e) {
            System.out.println("✗ Connection failed: " + e.getMessage());
        }
        return conn;
    
    }

    // Method to hash passwords using SHA-256
    public static String hashPassword(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            
            // Convert byte array to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Error hashing password: " + e.getMessage());
            return null;
        }
    }
    
    // Add record to database
    public void addRecord(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }

            pstmt.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
        }
    }
    
    // Authenticate user and set Session
    public String authenticate(String sql, String email, String password, String status) {
    String userType = null;
    try (Connection conn = connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setString(1, email);
        pst.setString(2, password); // Consider hashing this!
        pst.setString(3, status);
        
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            // Set all session data HERE
            Session.getInstance().setU_id(rs.getInt("u_id"));
            Session.getInstance().setUsername(rs.getString("username"));
            Session.getInstance().setEmail(rs.getString("email"));
            Session.getInstance().setStatus(rs.getString("status"));
            Session.getInstance().setType(rs.getString("type"));
            
            userType = rs.getString("type"); // Return the type for redirection
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return userType;
}
}