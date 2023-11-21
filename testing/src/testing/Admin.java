package testing;

import java.sql.*;

public class Admin {

    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=KAU_Events_Clubs;user=sa;password=12345";
    private static String admin_KAU_ID;

    public Admin() {
        // Constructor if needed
    }

    public static boolean validateAdmin(String admin_KAU_ID, String adminPassword) {
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                String sql = "SELECT * FROM AdminBase WHERE admin_KAU_ID=? AND adminPassword=?";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setString(1, admin_KAU_ID);
                    pst.setString(2, adminPassword);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            // If a matching record is found, set the details in the current instance
                            Admin.admin_KAU_ID = rs.getString("admin_KAU_ID");
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

    public boolean insertEvent(String eventName, String eventDescription, java.util.Date eventDate, String Admin_ID) {
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                String query = "insert into eventBase (eventName,eventDescription,eventDate,Admin_ID)values(?,?,?,?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, eventName);
                    pst.setString(2, eventDescription);
                    java.sql.Date sqlEventDate = new java.sql.Date(eventDate.getTime());
                    pst.setDate(3, sqlEventDate);
                    pst.setString(4, Admin_ID);
                    pst.executeUpdate();
                    return true; // Event insertion successful
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }
        return false; // Event insertion failed
    }

    public static boolean deleteEventFromDatabase(String eventNum) {
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                String query = "DELETE FROM eventBase WHERE eventNum = ?";

                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, eventNum);
                    int rowsAffected = pst.executeUpdate();

                    // Check if the deletion was successful
                    return rowsAffected > 0;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            return false;
        }
    }

    public static boolean updateEventInDatabase(String eventNum, String eventName, String eventDescription, java.util.Date eventDate, String adminID) {
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                String query = "UPDATE eventBase SET eventName=?, eventDescription=?, eventDate=?, Admin_ID=? WHERE eventNum=?";

                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, eventName);
                    pst.setString(2, eventDescription);
                    java.sql.Date sqlEventDate = new java.sql.Date(eventDate.getTime());
                    pst.setDate(3, sqlEventDate);
                    pst.setString(4, adminID);
                    pst.setString(5, eventNum);

                    int rowsAffected = pst.executeUpdate();

                    // Check if the update was successful
                    return rowsAffected > 0;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            return false;
        }
    }

    public boolean checkIfEventExistsInTable(String eventName) throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                String query = "SELECT * FROM eventBase WHERE eventName=?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, eventName);
                    try (ResultSet rs = pst.executeQuery()) {
                        // Check if a record with the given event name exists
                        return rs.next();
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Log or handle the exception as needed
            throw new SQLException("Error checking if event exists in table", e);
        }
    }

    public boolean insertClub(String clubCode, String clubName, String clubDescription, Date clubFounded) {
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                String query = "insert into clubBase (clubCode,clubName,clubDescription,clubFounded)values(?,?,?,?)";

                try (PreparedStatement pst = con.prepareStatement(query)) {
                    int clubCodeInt = Integer.parseInt(clubCode);
                    pst.setInt(1, clubCodeInt);
                    pst.setString(2, clubName);
                    pst.setString(3, clubDescription);

                    java.sql.Date sqlClubFounded = new java.sql.Date(clubFounded.getTime());
                    pst.setDate(4, sqlClubFounded);
                    pst.executeUpdate();

                    return true; // Club insertion successful
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }

        return false; // Club insertion failed
    }

    public boolean updateClub(String clubCode, String newClubCode, String clubName, String clubDescription, java.util.Date clubFounded) {
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                String query = "UPDATE clubBase SET clubCode=?, clubName=?, clubDescription=?, clubFounded=? WHERE clubCode=?";

                try (PreparedStatement pst = con.prepareStatement(query)) {
                    int newCode = Integer.parseInt(newClubCode);
                    pst.setInt(1, newCode);
                    pst.setString(2, clubName);
                    pst.setString(3, clubDescription);
                    java.sql.Date sqlClubFounded = new java.sql.Date(clubFounded.getTime());
                    pst.setDate(4, sqlClubFounded);
                    pst.setString(5, clubCode);

                    int rowsAffected = pst.executeUpdate();

                    // Check if the update was successful
                    return rowsAffected > 0;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            return false;
        }
    }

    public static boolean deleteClub(String clubCode) {
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                String query = "DELETE FROM clubBase WHERE clubCode=?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, clubCode);
                    int rowsAffected = pst.executeUpdate();

                    // Check if the deletion was successful
                    return rowsAffected > 0;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log the exception or handle it as needed
            return false;
        }
    }

    public static AdminFunctions loginAdmin(String admin_KAU_ID, String adminPassword) {
        if (validateAdmin(admin_KAU_ID, adminPassword)) {
            // If validation is successful, create an instance of AdminFunctions
            return new AdminFunctions();
        } else {
            return null; // Return null if validation fails
        }
    }
}
