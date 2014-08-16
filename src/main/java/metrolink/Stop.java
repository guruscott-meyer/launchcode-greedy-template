/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Scott Meyer
 */
@Entity
@Table( name = "stops" )
public class Stop {
    
    @Id
    @Column( name = "stop_id" )
    private int stopId;
    
    @Column( name = "stop_name" )
    private String stopName;
    
    @OneToMany
    @JoinColumn( name = "stops.stop_id")
    @IndexColumn( name = "stop_times.stop_id" )
    private List<StopTime> stopTimes;
    
    public Stop() {
        
    }
    
    public Stop( String stopName ) {
        this.stopName = stopName;
    }
    
    public int getStopId() {
        return this.stopId;
    }
    
    public void setStopId( int id ) {
        this.stopId = id;
    }
    
    public String getStopName() {
        return this.stopName;
    }
    
    public void setStopName( String stopName ) {
        this.stopName = stopName;
    }
    
    public void setStopTimes( List stopTimes ) {
        this.stopTimes = stopTimes;
    }
    
    public List getStopTimes() {
        return stopTimes;
    }
    
}
