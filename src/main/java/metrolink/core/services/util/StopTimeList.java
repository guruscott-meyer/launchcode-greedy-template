package metrolink.core.services.util;

import metrolink.core.entities.StopTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopTimeList {
    public List<StopTime> getStopTimes() {
        return stopTimes;
    }

    public StopTimeList(List<StopTime> stopTimes) {
        this.stopTimes = stopTimes;
    }

    public void setStopTimes(List<StopTime> stopTimes) {
        this.stopTimes = stopTimes;
    }

    private List<StopTime> stopTimes = new ArrayList<StopTime>();
}
