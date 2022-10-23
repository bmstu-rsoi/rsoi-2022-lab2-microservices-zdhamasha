package rsoi.lab2.ticket.model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ticket_uid",unique = true,nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String ticket_uid;

    @Column(name = "flight_number", nullable = false, length = 20)
    private String flight_number;

    @Column(name = "username", nullable = false, length = 80)
    private String username;

    public ticket() {
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicket_uid() {
        return ticket_uid;
    }

    public void setTicket_uid(String ticket_uid) {
        this.ticket_uid = ticket_uid;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "status", nullable = false, length = 20)
    private String status;
}