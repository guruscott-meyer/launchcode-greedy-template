package metrolink;

import java.sql.*;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * User: Scott Meyer
 * Date: 6/18/14
 * Time: 3:28 AM
 */
public class MetrolinkCalculatorTest {

    private static SessionFactory factory;
    private static MetrolinkCalculator metrolinkCalculator;
    
    private Session session;
    
    private static final double DELTA = 1e-15;
    
    @Before
    public void openDatabase() {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch( HibernateException ex ) {
            System.err.println( "Failed to create sessionFactory object." + ex );
            throw new ExceptionInInitializerError( ex );
        }
        session = factory.openSession();
        metrolinkCalculator = new MetrolinkCalculator();
    }
    
    @Test
    public void threeFifteenInWellstonReturnsSix() {
        String testTime = "15:15:00";
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Stop> list = session.createQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"WELLSTON METROLINK STATION\" GROUP BY arrival_time;"  ).list();
            long timeResult = metrolinkCalculator.getNextArrivalTime( list.get(0).getStopTimes(), testTime );
            
            assertEquals( 6.0f, timeResult, DELTA );
            
        } catch( HibernateException e ) {
            if( tx != null ) tx.rollback();
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            session.close();
        }
    }
    
    @Test
    public void noonInWellstonReturnsZero() {
        String testTime = "12:01:00";
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Stop> list = session.createQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"WELLSTON METROLINK STATION\" GROUP BY arrival_time;"  ).list();
            long timeResult = metrolinkCalculator.getNextArrivalTime( list.get(0).getStopTimes(), testTime );
            
            assertEquals( 6.0f, timeResult, DELTA );
            
        } catch( HibernateException e ) {
            if( tx != null ) tx.rollback();
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            session.close();
        }
    }
    
    @Test
    public void midnightInBrentwoodReturnsThree() {
        String testTime = "23:58:00";
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Stop> list = session.createQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"BRENTWOOD METROLINK STATION\" GROUP BY arrival_time;"  ).list();
            long timeResult = metrolinkCalculator.getNextArrivalTime( list.get(0).getStopTimes(), testTime );
            
            assertEquals( 6.0f, timeResult, DELTA );
            
        } catch( HibernateException e ) {
            if( tx != null ) tx.rollback();
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            session.close();
        }
    }
    
    @Test
    public void twoAMInBrentwoodReturnsOneForty() {
        String testTime = "2:00:00";
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Stop> list = session.createQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"BRENTWOOD METROLINK STATION\" GROUP BY arrival_time;"  ).list();
            long timeResult = metrolinkCalculator.getNextArrivalTime( list.get(0).getStopTimes(), testTime );
            
            assertEquals( 6.0f, timeResult, DELTA );
            
        } catch( HibernateException e ) {
            if( tx != null ) tx.rollback();
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            session.close();
        }
    }
    
    @After
    public void closeDatabase() {
        try {
            session.close();
        } catch( HibernateException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            session.close();
        }
    }
}
