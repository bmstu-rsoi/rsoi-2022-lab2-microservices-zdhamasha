package rsoi.lab2.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rsoi.lab2.ticket.model.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t where t.username = ?1")
    List<Ticket> getUserTickets(String username);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Ticket VALUES (id,?1,ticketUid,?2,?3,?4)", nativeQuery = true)
    void insertTicket(String flightNumber, String username, int price, String status);

}