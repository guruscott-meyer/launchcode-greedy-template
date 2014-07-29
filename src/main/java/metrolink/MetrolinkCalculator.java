/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink;

import java.sql.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Scott Meyer
 */
public class MetrolinkCalculator {
    
    public MetrolinkCalculator() {
        
    }
    
    public int printStops( ResultSet resultSet ) throws SQLException {
        int stopIndex = 1;
        while( resultSet.next() ) {
            System.out.print( stopIndex + ": ");
            System.out.println( resultSet.getString( 1 ));
            stopIndex++;
        }
        return stopIndex;
    }
    
    public int getStop( int stopIndex ) {
        Scanner scanner = new Scanner( System.in );
        int stop = 1;
        do {
            System.out.print( "Input current stop: " );
            stop = scanner.nextInt();
            System.out.print( "\n" );
        } while( stop < 1 || stop > stopIndex );
        
        return stop;
    }
    
    public String getStopName( ResultSet resultSet, int stop ) throws SQLException {
        int index = 0;
        do {
            if( index == stop ) break;
            index++;
        }
        while( resultSet.next() ); 
        return resultSet.getString( 1 );
    }
    
    public long getNextArrivalTime( ResultSet resultSet, String time ) throws SQLException {
        String first = resultSet.getString( 1 );
        String last = null;
        while( resultSet.next() ) {
            String current = resultSet.getString( 1 );
            //System.out.println( resultSet.getString(1) );
            if( current.compareTo( time ) >= 0 && last == null ) {
                last = current;
            }
        }
        if( last == null ) last = first;
        return LocalTime.now().until( LocalTime.parse( last ), ChronoUnit.MINUTES );
    }
    
}
