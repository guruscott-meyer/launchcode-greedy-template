package metrolink.core.services;

import metrolink.core.entities.Stop;
import metrolink.core.entities.StopTime;
import metrolink.core.entities.StopTrip;
import metrolink.core.services.util.StopTimeList;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public interface StopTimeService {

    public StopTime find( StopTrip id );

    public StopTimeList findAllStopTimes();

    public StopTimeList findStopTimes( int StopId );
}
