package metrolink;

import java.sql.*;
import metrolink.MetrolinkCalculator;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * User: Scott Meyer
 * Date: 6/18/14
 * Time: 3:28 AM
 */
public class MetrolinkCalculatorTest {

    private Connection connection;
    private Statement statement;
    
    private static final double DELTA = 1e-15;
    
    @Before
    public void openDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to find class for loading the database", e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/test/resources/metrolink.db");
            statement = connection.createStatement();
        } catch( SQLException sqle ) {
            System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
            System.exit(0);
        }
    }
    
    @Test
    public void threeFifteenInWellstonReturnsSix() {
        MetrolinkCalculator metrolinkCalculator = new MetrolinkCalculator();
        String testTime = "15:15:00";
        try {
            ResultSet resultSet = statement.executeQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"WELLSTON METROLINK STATION\" GROUP BY arrival_time;");
            long timeResult = metrolinkCalculator.getNextArrivalTime(resultSet, testTime );
            
            assertEquals( 6.0f, timeResult, DELTA );
            
        } catch( SQLException sqle ) {
            System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
            System.exit(0);
        }
    }
    
    @Test
    public void noonInWellstonReturnsZero() {
        MetrolinkCalculator metrolinkCalculator = new MetrolinkCalculator();
        String testTime = "12:01:00";
        try {
            ResultSet resultSet = statement.executeQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"WELLSTON METROLINK STATION\" GROUP BY arrival_time;");
            long timeResult = metrolinkCalculator.getNextArrivalTime(resultSet, testTime );
            
            assertEquals( 0.0f, timeResult, DELTA );
            
        } catch( SQLException sqle ) {
            System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
            System.exit(0);
        }
    }
    
    @Test
    public void midnightInBrentwoodReturnsThree() {
        MetrolinkCalculator metrolinkCalculator = new MetrolinkCalculator();
        String testTime = "23:58:00";
        try {
            ResultSet resultSet = statement.executeQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"BRENTWOOD METROLINK STATION\" GROUP BY arrival_time;");
            long timeResult = metrolinkCalculator.getNextArrivalTime(resultSet, testTime );
            
            assertEquals( 3.0f, timeResult, DELTA );
            
        } catch( SQLException sqle ) {
            System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
            System.exit(0);
        }
    }
    
    @Test
    public void twoAMInBrentwoodReturnsOneForty() {
        MetrolinkCalculator metrolinkCalculator = new MetrolinkCalculator();
        String testTime = "2:00:00";
        try {
            ResultSet resultSet = statement.executeQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"BRENTWOOD METROLINK STATION\" GROUP BY arrival_time;");
            long timeResult = metrolinkCalculator.getNextArrivalTime(resultSet, testTime );
            
            assertEquals( 140.0f, timeResult, DELTA );
            
        } catch( SQLException sqle ) {
            System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
            System.exit(0);
        }
    }
    
    @After
    public void closeDatabase() {
        try {
            statement.close();
        } catch( SQLException sqle ) {
            System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
            System.exit(0);
        }
    }
}
