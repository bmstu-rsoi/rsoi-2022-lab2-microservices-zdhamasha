package rsoi.lab2.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rsoi.lab2.ticket.repoistory.TicketRepoistory;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    @Autowired
    private TicketRepoistory ticketRepoistory;
}
