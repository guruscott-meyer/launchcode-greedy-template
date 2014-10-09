package metrolink.rest.mvc;

import metrolink.core.entities.StopTime;
import metrolink.core.entities.StopTrip;
import metrolink.core.services.StopTimeService;
import metrolink.core.services.util.StopList;
import metrolink.core.services.util.StopTimeList;
import metrolink.rest.resources.StopListResource;
import metrolink.rest.resources.StopTimeListResource;
import metrolink.rest.resources.StopTimeResource;
import metrolink.rest.resources.asm.StopListResourceAsm;
import metrolink.rest.resources.asm.StopTimeListResourceAsm;
import metrolink.rest.resources.asm.StopTimeResourceAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Scott Meyer on 10/6/14.
 */
@Controller
@RequestMapping(value="/rest/stop-times")
public class StopTimeController {
    private StopTimeService service;

    public StopTimeController(StopTimeService service) {
        this.service = service;
    }

    @RequestMapping(value="/{stopId}/{tripId}", method= RequestMethod.GET)
    public ResponseEntity<StopTimeResource> getStopTime( @PathVariable String stopId, @PathVariable String tripId ) {
        StopTrip stopTrip = new StopTrip();
        stopTrip.setStopId(stopId);
        stopTrip.setTripId(tripId);
        StopTime stopTime = service.find(stopTrip);
        if(stopTime != null) {
            StopTimeResource res = new StopTimeResourceAsm().toResource(stopTime);
            return new ResponseEntity<StopTimeResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<StopTimeResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<StopTimeListResource> findAllStopTimes() {
        StopTimeList stopTimeList = service.findAllStopTimes();
        StopTimeListResource stopTimeListRes = new StopTimeListResourceAsm().toResource(stopTimeList);
        return new ResponseEntity<StopTimeListResource>(stopTimeListRes, HttpStatus.OK);
    }

}
