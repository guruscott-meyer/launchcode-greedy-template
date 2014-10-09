package metrolink.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Meyer on 10/6/14.
 */
public class StopTimeListResource extends ResourceSupport {
    private int StopTimeId;

    public int getStopTimeId() {
        return StopTimeId;
    }

    public void setStopTimeId(int stopTimeId) {
        StopTimeId = stopTimeId;
    }

    public List<StopTimeResource> getStopTimeResources() {

        return stopTimeResources;
    }

    public void setStopTimeResources(List<StopTimeResource> stopTimeResources) {
        this.stopTimeResources = stopTimeResources;
    }

    private List<StopTimeResource> stopTimeResources = new ArrayList<StopTimeResource>();
}
