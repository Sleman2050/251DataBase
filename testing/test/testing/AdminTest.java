package testing;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.Date;
import java.sql.SQLException;

public class AdminTest {

    public AdminTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of validateAdmin method, of class Admin.
     */
    @Test
    public void testValidateAdmin() {
        System.out.println("validateAdmin");
        String admin_KAU_ID = "123";
        String adminPassword = "123";
        boolean expResult = true;
        boolean result = Admin.validateAdmin(admin_KAU_ID, adminPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertEvent method, of class Admin.
     */
    @Test
    public void testInsertEvent() {
        System.out.println("insertEvent");
        String eventName = "Test Event";
        String eventDescription = "This is a test event";
        Date eventDate = new Date(System.currentTimeMillis());
        String Admin_ID = "321";
        Admin instance = new Admin();
        boolean expResult = true;
        boolean result = instance.insertEvent(eventName, eventDescription, eventDate, Admin_ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteEventFromDatabase method, of class Admin.
     */
    @Test
    public void testInsertEventAndCheckIfExists() {
        try {
            // Mock data
            String eventName = "Test Event";
            String eventDescription = "This is a test event description.";
            Date eventDate = new Date(System.currentTimeMillis()); // Use the current date as a sample
            String adminID = "123"; // Replace with an appropriate admin ID for testing

            // Create an instance of the Admin class
            Admin admin = new Admin();

            // Call the insertEvent method
            boolean success = admin.insertEvent(eventName, eventDescription, eventDate, adminID);

            // Assert that the insertion was successful
            assertTrue("Event should be inserted successfully", success);

            // Check if the event exists in the table
            boolean eventExists = admin.checkIfEventExistsInTable(eventName);
            assertTrue("Event should exist in the table", eventExists);

        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateEventInDatabase() {
        try {
            // Assuming you have a valid eventNum, eventName, eventDescription, eventDate, and adminID
            String eventNum = "15";
            String eventName = "Updated Event";
            String eventDescription = "Updated Description";
            Date eventDate = new Date(System.currentTimeMillis()); // Set a valid date
            String adminID = "123";

            // Create an instance of the Admin class
            Admin admin = new Admin();

            // Call the updateEventInDatabase method
            boolean success = admin.updateEventInDatabase(eventNum, eventName, eventDescription, eventDate, adminID);

            // Assert that the update was successful
            assertTrue(success);

        } catch (Exception e) {
            // Handle any exceptions or failures
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testInsertClub() {
        Admin admin = new Admin();

        // Mocking input data
        String clubCode = "123";
        String clubName = "TestClub";
        String clubDescription = "Description";
        Date clubFounded = new Date(System.currentTimeMillis());

        boolean result = admin.insertClub(clubCode, clubName, clubDescription, clubFounded);

        assertTrue(result);
    }

    @Test
    public void testUpdateClub() {
        Admin admin = new Admin();

        // Mocking input data
        String clubCode = "123";
        String newClubCode = "456";
        String clubName = "UpdatedClub";
        String clubDescription = "UpdatedDescription";
        Date clubFounded = new Date(System.currentTimeMillis());

        boolean result = admin.updateClub(clubCode, newClubCode, clubName, clubDescription, clubFounded);

        assertTrue(result);
    }

    @Test
    public void testDeleteClub() {
        Admin admin = new Admin();

        // Mocking input data
        String clubCode = "456";

        boolean result = admin.deleteClub(clubCode);

        assertTrue(result);
    }
}
