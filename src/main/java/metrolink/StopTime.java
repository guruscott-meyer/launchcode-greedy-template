/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink;

import javax.persistence.*;

/**
 *
 * @author Scott Meyer
 */

@Entity
@Table( name = "stop_times" )
public class StopTime {
    
    @Id
    @Column( name = "stop_id" )
    private int id;
    
    @Column( name = "arrival_time" )
    private String arrivalTime;
    
    public StopTime() {
        
    }
    
    public StopTime( String arrivalTime ) {
        this.arrivalTime = arrivalTime;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId( int id ) {
        this.id = id;
    }
    
    public String getArrivalTime() {
        return this.arrivalTime;
    }
    
    public void setArrivalTime( String arrivalTime ) {
        this.arrivalTime = arrivalTime;
    }
    
    public boolean equals( Object obj ) {
        if( obj == null ) return false;
        if( !this.getClass().equals(obj.getClass())) return false;
        
        StopTime obj2 = (StopTime) obj;
        
        if( ( this.id == obj2.getId() ) && ( this.arrivalTime.equals( obj2.getArrivalTime() ) ) ) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        int temp = 0;
        temp = ( id + arrivalTime ).hashCode();
        return temp;
    }
                
}
