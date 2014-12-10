package metrolink.core.entities;

import java.io.Serializable;
/**
 *
 * @author Scott Meyer
 */
public class StopTrip implements Serializable{
    private String stopId;
    private String tripId;

    public StopTrip(String stopId, String tripId) {
        this.stopId = stopId;
        this.tripId = tripId;
    }

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
    @Override
    public String toString() {
        return stopId + "-" + tripId;
    }
}
