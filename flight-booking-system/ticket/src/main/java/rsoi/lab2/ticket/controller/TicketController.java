package rsoi.lab2.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rsoi.lab2.ticket.model.Status;
import rsoi.lab2.ticket.model.Ticket;
import rsoi.lab2.ticket.repository.TicketRepository;
import rsoi.lab2.ticket.requests.CreateTicketRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TicketController {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository)
    {
        this.ticketRepository = ticketRepository;
    }


    @GetMapping("")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }


    @GetMapping("/me")
    public ResponseEntity<?> getTickets(@RequestHeader(value = "X-User-Name") String username) {
        return new ResponseEntity<>(ticketRepository.getUserTickets(username), HttpStatus.OK);
    }

    @PostMapping("/tickets")
    public boolean createTicket(@RequestHeader(value = "X-User-Name") String username,
                               @RequestBody CreateTicketRequest ticketRequest) {

        Ticket ticket = new Ticket();
        ticket.setFlightNumber(ticketRequest.flightNumber);
        ticket.setPrice(Integer.parseInt(ticketRequest.price));
        ticket.setUsername(username);
        if(ticketRequest.paidFromBalance)
            ticket.setStatus(Status.PAID);
        else
            ticket.setStatus(Status.CANCELED);

        ticketRepository.save(ticket);
        return true;
    }

}
