package metrolink.core.repositories;

import metrolink.core.entities.Stop;
import metrolink.core.services.util.StopList;

/**
 * Created by Scott Meyer on 10/9/14.
 */
public interface StopRepo {

    public Stop find(int stopId);

    public StopList findAllStops();
}
