/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink;

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
//    @GeneratedValue(strategy = IDENTITY)
    private StopTrip stopTrip;
    
    @Column( name = "arrival_time" )
    private String arrivalTime;
    
//    @ManyToOne
//    @JoinColumn(name="stop_id", insertable=false, updatable=false)
//    private Stop stop;
    
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
    
//    public Stop getStop() {
//        return this.stop;
//    }
//    
//    public void setStop( Stop stop ) {
//        this.stop = stop;
//    }
    
//    @Override
//    public boolean equals( Object obj ) {
//        if( obj == null ) return false;
//        if( !this.getClass().equals(obj.getClass())) return false;
//        
//        StopTime obj2 = (StopTime) obj;
//        
//        if( ( this.stopId == obj2.getStopId() ) && ( this.arrivalTime.equals( obj2.getArrivalTime() ) ) ) {
//            return true;
//        }
//        return false;
//    }
//    
//    @Override
//    public int hashCode() {
//        int temp = ( stopId + arrivalTime ).hashCode();
//        return temp;
//    }
                
}
