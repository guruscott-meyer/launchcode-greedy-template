package metrolink.rest.mvc;

import metrolink.core.entities.Stop;
import metrolink.core.services.StopService;
import metrolink.core.services.util.StopList;
import metrolink.rest.resources.StopListResource;
import metrolink.rest.resources.StopResource;
import metrolink.rest.resources.asm.StopListResourceAsm;
import metrolink.rest.resources.asm.StopResourceAsm;
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
@RequestMapping(value="/rest/stops")
public class StopController {
    private StopService service;

    public StopController(StopService service) {
        this.service = service;
    }

    @RequestMapping(value="/{stopId}", method= RequestMethod.GET)
    public ResponseEntity<StopResource> getStop( @PathVariable int stopId ) {
        Stop stop = service.find(stopId);
        if(stop != null) {
            StopResource res = new StopResourceAsm().toResource(stop);
            return new ResponseEntity<StopResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<StopResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<StopListResource> findAllStops() {
        StopList stopList = service.findAllStops();
        StopListResource stopListRes = new StopListResourceAsm().toResource(stopList);
        return new ResponseEntity<StopListResource>(stopListRes, HttpStatus.OK);
    }

}