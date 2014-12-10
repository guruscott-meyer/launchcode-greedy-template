package metrolink.controllers;

import metrolink.core.entities.Stop;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Meyer on 12/9/14.
 */

@RestController
@RequestMapping(value="/metrostops")
public class StopController {

    @RequestMapping(value="/stops", method= RequestMethod.GET)
    public List<Stop> findStops() {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.sqlite.JDBC.class);
        dataSource.setUrl("jdbc:sqlite:C:\\Users\\Scott Meyer\\metrolink-project\\src\\main\\resources\\metrolink.db");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Stop> results = jdbcTemplate.query( "SELECT * FROM stops WHERE stop_name LIKE \"%METROLINK STATION\"",
                new RowMapper<Stop>() {
                    @Override
                    public Stop mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Stop(rs.getString("stop_name"), rs.getInt("stop_id"));
                    }
                });

        return results;

    }

}
