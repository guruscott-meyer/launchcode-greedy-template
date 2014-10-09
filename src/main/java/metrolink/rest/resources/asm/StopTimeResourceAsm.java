package metrolink.rest.resources.asm;

import metrolink.core.entities.Stop;
import metrolink.core.entities.StopTime;
import metrolink.rest.mvc.StopTimeController;
import metrolink.rest.resources.StopResource;
import metrolink.rest.resources.StopTimeResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopTimeResourceAsm extends ResourceAssemblerSupport<StopTime, StopTimeResource> {

    public StopTimeResourceAsm() {
        super(StopTimeController.class, StopTimeResource.class );
    }

    @Override
    public StopTimeResource toResource(StopTime stopTime) {
        StopTimeResource res = new StopTimeResource();
        res.setStopTrip(stopTime.getStopTrip());
        Link link = linkTo(methodOn(StopTimeController.class).getStopTime(stopTime.getStopTrip().getStopId(), stopTime.getStopTrip().getTripId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
