package rsoi.lab2.flight.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rsoi.lab2.flight.responses.FlightPage;
import rsoi.lab2.flight.responses.FlightResponse;
import rsoi.lab2.flight.usecases.FindAllFlights;
import rsoi.lab2.flight.usecases.FlightExistenceUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightsController {


    private final FindAllFlights findAllFlights;
    private final FlightExistenceUseCase flightExistenceUseCase;

    public FlightsController(FindAllFlights findAllFlights,
                             FlightExistenceUseCase flightExistenceUseCase) {
        this.findAllFlights = findAllFlights;
        this.flightExistenceUseCase = flightExistenceUseCase;
    }

    @GetMapping()
    public ResponseEntity<FlightPage> findAllFlights(@RequestParam int page,
                                                     @RequestParam int size) {
        List<FlightResponse> flights = findAllFlights.execute(PageRequest.of(page, size));
        return ResponseEntity.ok(new FlightPage(flights, page, size, flights.size()));
    }

    @GetMapping("isExists")
    public ResponseEntity<Boolean> isFlightExist(@RequestParam String flightNumber) {
        return ResponseEntity.ok(flightExistenceUseCase.execute(flightNumber));
    }
}
