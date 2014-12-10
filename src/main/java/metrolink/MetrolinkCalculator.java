/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import metrolink.core.entities.StopTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author Scott Meyer
 */

public class MetrolinkCalculator {
    
    private static final long ONEDAYINMINUTES = 1440;

    public long getNextArrivalTime( List<StopTime> stopTimes, String time ) {
        LocalTime[] timeArray = new LocalTime[ stopTimes.size() ];
        for( int i = 0; i < stopTimes.size(); i++ ) {
            timeArray[ i ] = convertTime( stopTimes.get( i ).getArrivalTime() );
        }
        Arrays.sort( timeArray );
        LocalTime convertedTime = convertTime( time );
        LocalTime timeResult = null;
        for (LocalTime currentTime : timeArray) {
//            System.out.println( currentTime );
            if( currentTime.compareTo( convertedTime ) >= 0 ) {
                timeResult = currentTime;
                break;
            }
        }
        if( timeResult == null ) {
            timeResult = timeArray[0];
        }
        long difference = convertedTime.until( timeResult, ChronoUnit.MINUTES );
        if( difference < 0 ) {
            difference += ONEDAYINMINUTES;
        }
        return difference;
    }
    
    private LocalTime convertTime( String time ) {
        String[] values = time.split( ":" );
        int hour = Integer.parseInt(values[0]);
        int minute = Integer.parseInt(values[1]);
        int second = 0;
        
        if( hour >= 24 ) {
            hour = hour - 24;
        }
        
        return LocalTime.of( hour, minute, second );
    }
    
}
