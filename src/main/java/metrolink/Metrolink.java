/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink;

import java.sql.*;
import metrolink.MetrolinkCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Scott Meyer
 */
public class Metrolink {
    
    private MetrolinkCalculator metrolinkCalculator;
    
    public void setMetrolinkCalculator( MetrolinkCalculator metrolinkCalculator ) {
        this.metrolinkCalculator = metrolinkCalculator;
    }
    
    public Metrolink() {
        
    }
    
    public void start() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:metrolink.db");
            statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            ResultSet resultSet = statement.executeQuery( "SELECT stop_name FROM stops WHERE stop_name LIKE \"%METROLINK STATION\" ORDER BY stop_name;");
            int stopIndex = metrolinkCalculator.printStops( resultSet );
            int stop = metrolinkCalculator.getStop( stopIndex );
            String station = metrolinkCalculator.getStopName( resultSet, stop );
            resultSet = statement.executeQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"" + station + "\" GROUP BY arrival_time ORDER BY arrival_time;" );
            long timeResult = metrolinkCalculator.getNextArrivalTime( resultSet );
            System.out.println("The next train is arriving in " + timeResult + " minutes." );
        } catch( SQLException sqle ) {
            System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
            System.exit(0);
        } finally {
            try {
                statement.close();
            } catch(SQLException sqle ) {
                System.err.println( sqle.getClass().getName() + ": " + sqle.getMessage() );
                System.exit(0);
            }
        }
        
    }
    
    public static void main(String[] varArgs) {
        ApplicationContext context = new ClassPathXmlApplicationContext( "application-context.xml");
        Metrolink obj = (Metrolink) context.getBean("metrolink");

        obj.start();
    }
    
}
