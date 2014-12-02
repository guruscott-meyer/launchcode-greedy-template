package metrolink.core.services.impl;

import metrolink.core.entities.Stop;
import metrolink.core.entities.StopTime;
import metrolink.core.entities.StopTrip;
import metrolink.core.repositories.StopRepo;
import metrolink.core.repositories.StopTimeRepo;
import metrolink.core.services.StopTimeService;
import metrolink.core.services.exceptions.StopDoesNotExistException;
import metrolink.core.services.exceptions.StopTimeDoesNotExistException;
import metrolink.core.services.util.StopTimeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Scott Meyer on 12/1/14.
 */

@Service
@Transactional
public class StopTimeServiceImpl implements StopTimeService {

    @Autowired
    private StopTimeRepo stopTimeRepo;

    @Autowired
    private StopRepo stopRepo;

    @Override
    public StopTime find(StopTrip id) {
        StopTime stopTime = stopTimeRepo.find(id);
        if(stopTime == null ) {
            throw new StopTimeDoesNotExistException();
        }
        return stopTime;
    }

    @Override
    public StopTimeList findAllStopTimes() {
        return new StopTimeList( stopTimeRepo.findAllStopTimes());
    }

    @Override
    public StopTimeList findStopTimes(int stopId) {
        Stop stop = stopRepo.find(stopId);
        if( stop == null ) {
            throw new StopDoesNotExistException();
        }
        return new StopTimeList( stopTimeRepo.findStopTimes(stop));
    }
}
