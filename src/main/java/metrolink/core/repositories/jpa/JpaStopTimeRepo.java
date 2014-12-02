package metrolink.core.repositories.jpa;

import metrolink.core.entities.Stop;
import metrolink.core.entities.StopTime;
import metrolink.core.entities.StopTrip;
import metrolink.core.repositories.StopTimeRepo;
import metrolink.core.services.util.StopList;
import metrolink.core.services.util.StopTimeList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Scott Meyer on 12/1/14.
 */
@Repository
public class JpaStopTimeRepo implements StopTimeRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public StopTime find(StopTrip stopTrip) {
        return em.find(StopTime.class, stopTrip);
    }

    @Override
    public List<StopTime> findAllStopTimes() {
        Query query = em.createQuery("SELECT a FROM stop_times a");
        return query.getResultList();
    }

    public List<StopTime> findStopTimes( Stop stop ) {
        Query query = em.createQuery( "SELECT b FROM stop_times b WHERE b.stop_id = ?1");
        query.setParameter(1, stop);
        return query.getResultList();
    }
}
