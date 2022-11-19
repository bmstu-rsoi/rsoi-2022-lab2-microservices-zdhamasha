package rsoi.lab2.ticket.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rsoi.lab2.ticket.requests.PurchaseTicketRequest;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketsController {

//    private final TicketRepository ticketRepository;
//
//    @Autowired
//    public TicketsController(TicketRepository ticketRepository)
//    {
//        this.ticketRepository = ticketRepository;
//    }
//
//
//    @GetMapping("")
//    public List<Ticket> getAllTickets() {
//        return ticketRepository.findAll();
//    }
//
//
//    @GetMapping("/me")
//    public ResponseEntity<?> getTickets(@RequestHeader(value = "X-User-Name") String username) {
//        return new ResponseEntity<>(ticketRepository.getUserTickets(username), HttpStatus.OK);
//    }

    @PostMapping()
    public boolean createTicket(@RequestBody PurchaseTicketRequest request) {
        return false;
    }

//    @PostMapping()
//    public ResponseEntity<PurchaseFlightResponse> findAllFlights(@RequestParam int page,
//                                                                 @RequestParam int size) {
//        List<FlightResponse> flights = findAllFlights.execute(PageRequest.of(page, size));
//        return ResponseEntity.ok(new FlightPage(flights, page, size, flights.size()));
//    }

}
