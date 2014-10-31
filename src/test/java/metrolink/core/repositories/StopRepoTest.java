package metrolink.core.repositories;

import metrolink.core.repositories.jpa.JpaStopRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Scott Meyer on 10/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class StopRepoTest {

    @Autowired
    private StopRepo repo;

    @Test
    public void test() {

    }

}
