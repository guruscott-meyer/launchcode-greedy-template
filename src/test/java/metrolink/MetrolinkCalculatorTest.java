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
    
    @Before
    public void openDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:metrolink.db");
            statement = connection.createStatement();
        } catch( SQLException sqle ) {
            System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
            System.exit(0);
        }
    }
    
    @Test
    public void noonInWellstonReturnsZero() {
        MetrolinkCalculator metrolinkCalculator = new MetrolinkCalculator();
        String testTime = "12:01";
        try {
            ResultSet resultSet = statement.executeQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stop.stop_name = \"WELLSTON METROLINK STATION\" GROUP BY arrival_time;");
            long timeResult = metrolinkCalculator.getNextArrivalTime(resultSet, testTime );
            
            assertEquals( 0.0f, timeResult );
            
        } catch( SQLException sqle ) {
            System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
            System.exit(0);
        }
    }
    
    @Test
    public void midnightInBrentwoodReturnsThree() {
        MetrolinkCalculator metrolinkCalculator = new MetrolinkCalculator();
        String testTime = "23:58";
        try {
            ResultSet resultSet = statement.executeQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stop.stop_name = \"BRENTWOOD METROLINK STATION\" GROUP BY arrival_time;");
            long timeResult = metrolinkCalculator.getNextArrivalTime(resultSet, testTime );
            
            assertEquals( 3.0f, timeResult );
            
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
