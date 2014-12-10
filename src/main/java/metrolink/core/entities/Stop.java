package metrolink.core.entities;

/**
 * Created by Scott Meyer on 12/9/14.
 */
import java.util.List;
/**
 *
 * @author Scott Meyer
 */

public class Stop {
    private int stopId;
    private String stopName;

    public Stop() {
    }

    public Stop(String stopName, int stopId) {
        this.stopName = stopName;
        this.stopId = stopId;
    }

    public Stop( String stopName ) {
        this.stopName = stopName;
    }
    public int getStopId() {
        return this.stopId;
    }
    public void setStopId( int id ) {
        this.stopId = id;
    }
    public String getStopName() {
        return this.stopName;
    }
    public void setStopName( String stopName ) {
        this.stopName = stopName;
    }
}