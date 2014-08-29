/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metrolink;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Scott Meyer
 */
@Embeddable
public class StopTrip implements Serializable{
    
    @Column(name="stop_id")
    private String stopId;
    
    @Column(name="trip_id")
    private String tripId;
    
    public void setStopId (String stopId) {
        this.stopId = stopId;
    }
    
    public void setTripId (String tripId) {
        this.tripId = tripId;
    }
    
    public String getStopId() {
        return this.stopId;
    }
    
    public String getTripId() {
        return this.tripId;
    }

}
