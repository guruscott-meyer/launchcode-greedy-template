package metrolink.rest.resources.asm;

import metrolink.core.services.util.StopList;
import metrolink.rest.mvc.StopController;
import metrolink.rest.resources.StopListResource;
import metrolink.rest.resources.StopResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopListResourceAsm extends ResourceAssemblerSupport<StopList, StopListResource> {

    public StopListResourceAsm(){
        super(StopController.class, StopListResource.class);
    }

    @Override
    public StopListResource toResource(StopList list) {
        List<StopResource> resources = new StopResourceAsm().toResources(list.getStops());
        StopListResource listResource = new StopListResource();
        listResource.setStopResources(resources);
        listResource.add(linkTo(methodOn(StopController.class).findAllStops()).withSelfRel());
        return listResource;
    }
}
