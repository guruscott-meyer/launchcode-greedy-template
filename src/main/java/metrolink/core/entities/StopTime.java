/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink.core.entities;

import metrolink.core.entities.StopTrip;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Scott Meyer
 */
@Entity
@Table( name = "stop_times" )
public class StopTime {
    
    @EmbeddedId
    private StopTrip stopTrip;
    
    @Column( name = "arrival_time" )
    private String arrivalTime;

    public StopTime() {
        
    }
    
    public StopTime( String arrivalTime ) {
        this.arrivalTime = arrivalTime;
    }
    
    public StopTrip getStopTrip() {
        return this.stopTrip;
    }
    
    public void setStopTrip( StopTrip stopTrip ) {
        this.stopTrip = stopTrip;
    }
    
    public String getArrivalTime() {
        return this.arrivalTime;
    }
    
    public void setArrivalTime( String arrivalTime ) {
        this.arrivalTime = arrivalTime;
    }
                
}
