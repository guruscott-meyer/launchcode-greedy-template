package metrolink.core.repositories;

import metrolink.core.entities.Stop;
import metrolink.core.services.util.StopList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Scott Meyer on 10/9/14.
 */
public interface StopRepo {

    public Stop find(int stopId);

    public Stop findStopByName(String name);

    public List<Stop> findAllStops();
}
