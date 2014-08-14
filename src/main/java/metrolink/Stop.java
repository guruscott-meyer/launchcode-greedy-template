/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink;

import java.util.List;
import javax.persistence.*;
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
    private int id;
    
    @Column( name = "stop_name" )
    private String stopName;
    
    @OneToMany
    @JoinColumn( name = "stop_id")
    @IndexColumn( name = "stop_id" )
    private List<StopTime> stopTimes;
    
    public Stop() {
        
    }
    
    public Stop( String stopName ) {
        this.stopName = stopName;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId( int id ) {
        this.id = id;
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
