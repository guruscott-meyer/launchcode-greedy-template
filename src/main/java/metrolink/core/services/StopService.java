package metrolink.core.services;

import metrolink.core.entities.Stop;
import metrolink.core.services.util.StopList;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public interface StopService {

    public Stop find(int stopId);

    public StopList findAllStops();

}
