package rsoi.lab2.ticket.repoistory;
import org.springframework.data.jpa.repository.JpaRepository;
import rsoi.lab2.ticket.model.Ticket;

public interface TicketRepoistory extends JpaRepository<Ticket, Long> {

}