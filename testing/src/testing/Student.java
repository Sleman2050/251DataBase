/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.sql.*;

public class Student {

    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=KAU_Events_Clubs;user=sa;password=12345";
    private static String KAU_ID;
    private static String studentName;
    // Constructor

    static String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Student() {
        // Initialize other fields if needed
    }

    // Getter methods
    public static String getKAU_ID() {
        return KAU_ID;
    }

    public static String getStudentName() {
        return studentName;
    }

    public static boolean validateStudent(String KAU_ID, String password) {
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                String sql = "SELECT * FROM student WHERE KAU_ID=? AND password=?";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setString(1, KAU_ID);
                    pst.setString(2, password);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            // If a matching record is found, set the details in the current instance
                            // Assuming the columns in the database match the fields in the class
                            Student.KAU_ID = rs.getString("KAU_ID");
                            Student.studentName = rs.getString("studentName");
                            // Set other fields as needed
                            return true;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
        return false;
    }

    // Method to get the current instance
    public static Student getCurrentInstance() {
        return new Student();
    }
}
