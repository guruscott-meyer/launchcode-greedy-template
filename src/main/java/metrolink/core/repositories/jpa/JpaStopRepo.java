package metrolink.core.repositories.jpa;

import metrolink.core.entities.Stop;
import metrolink.core.repositories.StopRepo;
import metrolink.core.services.util.StopList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Scott Meyer on 10/9/14.
 */
@Repository
public class JpaStopRepo implements StopRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Stop find(int stopId){
        return em.find(Stop.class, stopId);
    }

    @Override
    public Stop findStopByName(String name) {
        Query query = em.createQuery("SELECT a FROM stops a WHERE a.stop_name=?1");
        query.setParameter(1, name);
        List<Stop> stops = query.getResultList();
        if(stops.size() == 0) {
            return null;
        } else {
            return stops.get(0);
        }
    }

    @Override
    public List<Stop> findAllStops() {
        Query query = em.createQuery("SELECT a FROM stops a");
        return query.getResultList();
    }
}
