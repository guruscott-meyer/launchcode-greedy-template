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
            System.out.println( resultSet.getString( "stop_name" ));
            stopIndex++;
        }
        return stopIndex;
    }
    
    public int getStop( int stopIndex ) {
        Scanner scanner = new Scanner( System.in );
        int stop = 0;
        do {
            System.out.print( "Input current stop: " );
            stop = scanner.nextInt();
            System.out.print( "\n" );
        } while( stop < 1 || stop > stopIndex );
        
        return stop;
    }
    
    public String getStopName( ResultSet resultSet, int stop ) throws SQLException {
        resultSet.absolute( stop );
        return resultSet.getString( "stop_name");
    }
    
    public long getNextArrivalTime( ResultSet resultSet ) throws SQLException {
        LocalTime result = resultSet.getTime( "arrival_time" ).toLocalTime();
        return LocalTime.now().until( result, ChronoUnit.MINUTES );
    }
    
}
