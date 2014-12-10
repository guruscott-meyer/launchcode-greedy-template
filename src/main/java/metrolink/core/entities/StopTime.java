package metrolink.core.entities;

/**
 * Created by Scott Meyer on 12/9/14.
 */
public class StopTime {
    private StopTrip stopTrip;
    private String arrivalTime;
    public StopTime() {
    }

    public StopTime(StopTrip stopTrip, String arrivalTime) {
        this.stopTrip = stopTrip;
        this.arrivalTime = arrivalTime;
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
