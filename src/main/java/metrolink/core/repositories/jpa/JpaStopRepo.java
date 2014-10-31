package metrolink.core.repositories.jpa;

import metrolink.core.entities.Stop;
import metrolink.core.repositories.StopRepo;
import metrolink.core.services.util.StopList;
import org.springframework.stereotype.Repository;

/**
 * Created by Scott Meyer on 10/9/14.
 */
@Repository
public class JpaStopRepo implements StopRepo {
    @Override
    public Stop find(int stopId) {
        return null;
    }

    @Override
    public StopList findAllStops() {
        return null;
    }
}
