package metrolink.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopListResource extends ResourceSupport {
    private int stopId;

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public List<StopResource> getStopResources() {
        return stopResources;
    }

    public void setStopResources(List<StopResource> stopResources) {
        this.stopResources = stopResources;
    }

    private List<StopResource> stopResources = new ArrayList<StopResource>();

}
