package rsoi.lab2.flight.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rsoi.lab2.flight.responses.FlightPage;
import rsoi.lab2.flight.responses.FlightResponse;
import rsoi.lab2.flight.usecases.FindAllFlights;

import java.util.List;

import static com.sun.xml.bind.v2.runtime.reflect.Utils.LOGGER;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightsController {


    private final FindAllFlights findAllFlights;

    public FlightsController(FindAllFlights findAllFlights) {
        this.findAllFlights = findAllFlights;
    }

    @GetMapping()
    public ResponseEntity<FlightPage> findAllFlights(@RequestParam int page,
                                                     @RequestParam int size) {
        LOGGER.info("received a request to list flights");
        List<FlightResponse> flights = findAllFlights.execute(PageRequest.of(page, size));
        return ResponseEntity.ok(new FlightPage(flights, page, size, flights.size()));
    }
}
