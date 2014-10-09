package metrolink.rest.resources;

import metrolink.core.entities.StopTime;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopResource extends ResourceSupport {

    public List<StopTime> getStopTimes() {
        return stopTimes;
    }

    public void setStopTimes(List<StopTime> stopTimes) {
        this.stopTimes = stopTimes;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    private int stopId;
    private String stopName;
    private List<StopTime> stopTimes;


}
