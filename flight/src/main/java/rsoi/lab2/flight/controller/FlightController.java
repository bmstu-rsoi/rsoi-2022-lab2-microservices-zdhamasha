package rsoi.lab2.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rsoi.lab2.flight.model.Airport;
import rsoi.lab2.flight.responses.AvaiableFlight;
import rsoi.lab2.flight.usecases.ListAvaiableFlightsUseCase;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private static List<AvaiableFlight> avaiableFlights = new ArrayList<>();
    private static List<Airport> airports = new ArrayList<>();

    static {
        airports.add(new Airport(1,"Queen Ailia Airport","Jordan","Amman"));
        avaiableFlights.add(new AvaiableFlight(1000L,new Timestamp(new Date().getTime()),50,"ALLO",airports));

    }
//    @Autowired
//    private ListAvaiableFlightsUseCase listAvaiableFlightsUseCase;

    @GetMapping()
    public  List<AvaiableFlight> listAvaiableFlights()

    {
//        return listAvaiableFlightsUseCase.excute();
        return avaiableFlights;
    }
}
