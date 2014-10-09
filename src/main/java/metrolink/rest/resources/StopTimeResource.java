package metrolink.rest.resources;

import metrolink.core.entities.StopTrip;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopTimeResource extends ResourceSupport {

    private StopTrip stopTrip;

    public StopTrip getStopTrip() {
        return stopTrip;
    }

    public void setStopTrip(StopTrip stopTrip) {
        this.stopTrip = stopTrip;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    private String arrivalTime;
}
