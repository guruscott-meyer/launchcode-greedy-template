package metrolink.rest.resources.asm;

import metrolink.core.services.util.StopList;
import metrolink.core.services.util.StopTimeList;
import metrolink.rest.mvc.StopController;
import metrolink.rest.mvc.StopTimeController;
import metrolink.rest.resources.StopListResource;
import metrolink.rest.resources.StopResource;
import metrolink.rest.resources.StopTimeListResource;
import metrolink.rest.resources.StopTimeResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopTimeListResourceAsm extends ResourceAssemblerSupport<StopTimeList, StopTimeListResource>{

    public StopTimeListResourceAsm(){
        super(StopTimeController.class, StopTimeListResource.class);
    }

    @Override
    public StopTimeListResource toResource(StopTimeList list) {
        List<StopTimeResource> resources = new StopTimeResourceAsm().toResources(list.getStopTimes());
        StopTimeListResource listResource = new StopTimeListResource();
        listResource.setStopTimeResources(resources);
        listResource.add(linkTo(methodOn(StopTimeController.class).findAllStopTimes()).withSelfRel());
        return listResource;
    }
}
