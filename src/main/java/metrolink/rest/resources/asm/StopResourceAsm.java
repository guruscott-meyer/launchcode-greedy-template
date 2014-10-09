package metrolink.rest.resources.asm;

import metrolink.core.entities.Stop;
import metrolink.rest.mvc.StopController;
import metrolink.rest.resources.StopResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopResourceAsm extends ResourceAssemblerSupport<Stop, StopResource> {

    public StopResourceAsm() {
        super( StopController.class, StopResource.class );
    }

    @Override
    public StopResource toResource( Stop stop ) {
        StopResource res = new StopResource();
        res.setStopId(stop.getStopId());
        res.setStopName(stop.getStopName());
        Link link = linkTo(methodOn(StopController.class).getStop(stop.getStopId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
