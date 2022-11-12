package rsoi.lab2.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tickets")
@IdClass(Ticket.class)
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "flightNumber", nullable = false, length = 20)
    private String flightNumber;

    @Id
    @Column(name = "ticketUid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketUid;

    @Column(name = "username", nullable = false, length = 80)
    private String username;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getticketUid() {
        return ticketUid;
    }

    public void setticketUid(Long ticketUid) {
        this.ticketUid = ticketUid;
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

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }




    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", ticketUid=" + ticketUid +
                ", username='" + username + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }

    public Ticket(Long id, String flightNumber, Long ticketUid, String username, int price, Status status) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.ticketUid = ticketUid;
        this.username = username;
        this.price = price;
        this.status = status;
    }
}