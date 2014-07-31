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
import java.util.ArrayList;
import java.util.Arrays;

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
        
        ArrayList<LocalTime> timeList = new ArrayList();
        while( resultSet.next() ) {
            timeList.add( convertTime( resultSet.getString( 1 ) ) );
        }
        LocalTime[] timeArray = new LocalTime[ timeList.size() ];
        timeList.toArray( timeArray );
        Arrays.sort( timeArray );
        LocalTime convertedTime = convertTime( time );
        LocalTime timeResult = null;
        for (LocalTime currentTime : timeArray) {
            if( currentTime.compareTo( convertedTime ) >= 0 ) {
                timeResult = currentTime;
                break;
            }
        }
        if( timeResult == null ) timeResult = timeArray[0];
        return LocalTime.now().until( timeResult, ChronoUnit.MINUTES );
    }
    
    private LocalTime convertTime( String time ) {
        String[] values = time.split( ":" );
        int hour = new Integer( values[0] ).intValue();
        int minute = new Integer( values[1] ).intValue();
        int second = 0;
        
        if( hour >= 24 ) {
            hour = hour - 24;
        }
        
        return LocalTime.of( hour, minute, second );
    }
    
}
