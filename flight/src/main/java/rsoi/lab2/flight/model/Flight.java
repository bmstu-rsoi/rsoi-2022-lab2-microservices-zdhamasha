package rsoi.lab2.flight.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "date_time", nullable = false)
    private Timestamp date_time;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "flight_number", nullable = false, length = 20)
    private String flight_number;

    @OneToMany(mappedBy = "id")
    private List<Airport> airports;

    public Flight() {
    }

    public Flight(Long id, Timestamp date_time, Integer price, String flight_number, List<Airport> airports) {
        this.id = id;
        this.date_time = date_time;
        this.price = price;
        this.flight_number = flight_number;
        this.airports = airports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", date_time=" + date_time +
                ", price=" + price +
                ", flight_number='" + flight_number + '\'' +
                ", airports=" + airports +
                '}';
    }
}
