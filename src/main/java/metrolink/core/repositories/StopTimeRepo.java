package metrolink.core.repositories;

import metrolink.core.entities.Stop;
import metrolink.core.entities.StopTime;
import metrolink.core.entities.StopTrip;
import metrolink.core.services.util.StopTimeList;

import java.util.List;

/**
 * Created by Scott Meyer on 12/1/14.
 */
public interface StopTimeRepo {

    public StopTime find( StopTrip stopTrip );

    public List<StopTime> findAllStopTimes();

    public List<StopTime> findStopTimes( Stop stop );
}
