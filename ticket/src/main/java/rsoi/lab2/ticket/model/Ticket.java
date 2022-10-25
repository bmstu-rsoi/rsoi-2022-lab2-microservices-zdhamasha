package rsoi.lab2.ticket.model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "flight_number", nullable = false, length = 20)
    private String flight_number;

    @Column(name = "ticket_uid",unique = true,nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private UUID ticket_uid;

    @Column(name = "username", nullable = false, length = 80)
    private String username;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getTicket_uid() {
        return ticket_uid;
    }

    public void setTicket_uid(UUID ticket_uid) {
        this.ticket_uid = ticket_uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", flight_number='" + flight_number + '\'' +
                ", ticket_uid=" + ticket_uid +
                ", username='" + username + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }

    public Ticket(Integer id, String flight_number, UUID ticket_uid, String username, int price, Status status) {
        this.id = id;
        this.flight_number = flight_number;
        this.ticket_uid = ticket_uid;
        this.username = username;
        this.price = price;
        this.status = status;
    }
}