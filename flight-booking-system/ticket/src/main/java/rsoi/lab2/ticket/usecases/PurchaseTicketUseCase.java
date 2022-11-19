package rsoi.lab2.ticket.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.ticket.repository.TicketRepository;
import rsoi.lab2.ticket.requests.PurchaseTicketRequest;
import rsoi.lab2.ticket.responses.PurchaseTicketResponse;

@Component
public class PurchaseTicketUseCase {

    private final TicketRepository ticketRepository;

    public PurchaseTicketUseCase(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public PurchaseTicketResponse execute(PurchaseTicketRequest request){
        return null;
    }
}
