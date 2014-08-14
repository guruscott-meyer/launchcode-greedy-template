/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink;

import java.time.LocalTime;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Scott Meyer
 */

@Component
public class Metrolink {
    
    @Autowired
    private MetrolinkCalculator metrolinkCalculator;
    
    private static SessionFactory factory;
    
    public void start() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
//            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/metrolink.db");
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery( "SELECT stop_name FROM stops WHERE stop_name LIKE \"%METROLINK STATION\" ORDER BY stop_name;");
            List<Stop> list = session.createQuery( "FROM stops").list();
//            int stopIndex = metrolinkCalculator.printStops( resultSet );
            metrolinkCalculator.printStops( list );
//            resultSet.close();
            int stop = metrolinkCalculator.getStop( list.size() );
//            ResultSet resultSet2 = statement.executeQuery( "SELECT stop_name FROM stops WHERE stop_name LIKE \"%METROLINK STATION\" ORDER BY stop_name;");
//            String station = metrolinkCalculator.getStopName( list, resultSet2 );
//            resultSet2.close();
            System.out.println( "You selected: " + list.get( stop ).getStopName() );
//            ResultSet resultSet3 = statement.executeQuery( "SELECT arrival_time FROM stops NATURAL JOIN stop_times WHERE stops.stop_name = \"" + station + "\" GROUP BY arrival_time;" );
            long timeResult = metrolinkCalculator.getNextArrivalTime( list.get( stop ).getStopTimes(), LocalTime.now().toString() );
//            resultSet3.close();
            System.out.println("The next train is arriving in " + timeResult + " minutes." );
        } catch( HibernateException e ) {
            if( tx != null ) tx.rollback();
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            session.close();
        }
        
    }
    
    public static void main(String[] varArgs) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch( Throwable ex ) {
            System.err.println( "Failed to create sessionFactory object." + ex );
            throw new ExceptionInInitializerError( ex );
        }
        ApplicationContext context = new ClassPathXmlApplicationContext( "application-context.xml");
        Metrolink obj = (Metrolink) context.getBean("metrolink");

        obj.start();
    }
    
}
