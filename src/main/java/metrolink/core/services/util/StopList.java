package metrolink.core.services.util;

import metrolink.core.entities.Stop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopList {

    private List<Stop> stops = new ArrayList<Stop>();

    public StopList(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}
