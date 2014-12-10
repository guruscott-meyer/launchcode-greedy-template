package metrolink.controllers;

import metrolink.MetrolinkCalculator;
import metrolink.core.entities.Stop;
import metrolink.core.entities.StopTime;
import metrolink.core.entities.StopTrip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Scott Meyer on 12/9/14.
 */

@RestController
@RequestMapping(value="/metrolink")
public class StopTimeController {

    @RequestMapping(value="/next_stop", method= RequestMethod.GET)
    public long getNextArrivalTime(@RequestParam(value="stop") int stop) {

        MetrolinkCalculator metrolinkCalculator = new MetrolinkCalculator();

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.sqlite.JDBC.class);
        dataSource.setUrl("jdbc:sqlite:C:\\Users\\Scott Meyer\\metrolink-project\\src\\main\\resources\\metrolink.db");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<StopTime> results = jdbcTemplate.query("SELECT * FROM stop_times WHERE stop_id = ?",
                new Object[]{stop},
                new RowMapper<StopTime>() {
                    @Override
                    public StopTime mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new StopTime(new StopTrip(rs.getString("stop_id"), rs.getString("trip_id")), rs.getString("arrival_time"));
                    }
                });

        return metrolinkCalculator.getNextArrivalTime(results, LocalTime.now().toString());
    }

}
