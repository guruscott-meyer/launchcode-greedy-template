package metrolink.mvc;

import metrolink.core.entities.Stop;
import metrolink.core.entities.StopTime;
import metrolink.core.entities.StopTrip;
import metrolink.core.services.StopService;
import metrolink.core.services.StopTimeService;
import metrolink.rest.mvc.StopController;
import metrolink.rest.mvc.StopTimeController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * Created by Scott Meyer on 9/30/14.
 */
public class StopQueryControllerTest {

//    @InjectMocks
//    private StopController controller;

    @InjectMocks
    private StopTimeController timeController;

//    @Mock
//    private StopService service;

    @Mock
    private StopTimeService timeService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks( this );

        mockMvc = MockMvcBuilders.standaloneSetup( timeController ).build();

    }

//    @Test
//    public void test() throws Exception {
//        mockMvc.perform( post("/test")
//                .content( "{\"title\":\"Test Title\"}" )
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(jsonPath( "$.title", is("Test Title") ))
//                .andDo(print());
//    }

//    @Test
//    public void getExistingStopQuery() throws Exception {
//        Stop stop = new Stop();
//        stop.setStopId(500);
//        stop.setStopName("Test Title");
//
//        when( service.find( 500 ) ).thenReturn(stop);
//
//        mockMvc.perform(get("/rest/stops/500"))
//                .andDo(print())
//                .andExpect(jsonPath("$.stopName", is(stop.getStopName())))
//                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/stops/500"))))
//                .andExpect(status().isOk());
//    }

    @Test
    public void getExistingStopTime() throws Exception {
        StopTime stopTime = new StopTime();
        StopTrip stopTrip = new StopTrip();
        stopTrip.setStopId("1");
        stopTrip.setTripId("1");
        stopTime.setStopTrip(stopTrip);
        stopTime.setArrivalTime("11:30");

        when( timeService.find( stopTrip )).thenReturn(stopTime);

        mockMvc.perform(get("/rest/stop-times/1/1"))
                .andExpect(jsonPath("$.arrivalTime", is(stopTime.getArrivalTime())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/stop-times/1/1"))))
                .andExpect(status().isOk());

    }


}
