package rsoi.lab2.flight.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rsoi.lab2.flight.model.Flight;
import rsoi.lab2.flight.repoistory.FlightRepoistory;
import rsoi.lab2.flight.responses.AvaiableFlight;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListAvaiableFlightsUseCase {

    @Autowired
    private FlightRepoistory flightRepoistory ;

    public List<AvaiableFlight> excute()
    {
        return  flightRepoistory.findAll()
                .stream()
                .map(this::toAvaiableFlight)
                .collect(Collectors.toList());
    }

    private AvaiableFlight toAvaiableFlight(Flight flight) {
        AvaiableFlight avaiableFlight = new AvaiableFlight();
        avaiableFlight.setFlight_number(flight.getFlight_number());
        avaiableFlight.setId(flight.getId());
        avaiableFlight.setAirports(flight.getAirports());
        avaiableFlight.setPrice(flight.getPrice());
        avaiableFlight.setDate_time(flight.getDate_time());

        return avaiableFlight;
    }

}
