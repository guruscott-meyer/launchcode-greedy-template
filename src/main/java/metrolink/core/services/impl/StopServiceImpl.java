package metrolink.core.services.impl;

import metrolink.core.entities.Stop;
import metrolink.core.repositories.StopRepo;
import metrolink.core.services.StopService;
import metrolink.core.services.exceptions.StopDoesNotExistException;
import metrolink.core.services.util.StopList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Scott Meyer on 12/1/14.
 */

@Service
@Transactional
public class StopServiceImpl implements StopService {

    @Autowired
    private StopRepo stopRepo;

    @Override
    public Stop find(int stopId) {
        Stop stop = stopRepo.find(stopId);
        if( stop == null ) {
            throw new StopDoesNotExistException();
        }
        return stop;
    }

    @Override
    public Stop findByStopName(String name) {
        return stopRepo.findStopByName(name);
    }

    @Override
    public StopList findAllStops() {
        return new StopList (stopRepo.findAllStops());
    }
}
