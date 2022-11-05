package rsoi.lab2.flight.responses;

import rsoi.lab2.flight.model.Airport;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class AvaiableFlight {

    private Long id;

    private Timestamp date_time;

    private Integer price;

    private String flight_number;

    private List<Airport> airports;

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

    public AvaiableFlight() {
    }

    public AvaiableFlight(Long id, Timestamp date_time, Integer price, String flight_number, List<Airport> airports) {
        this.id = id;
        this.date_time = date_time;
        this.price = price;
        this.flight_number = flight_number;
        this.airports = airports;
    }

    @Override
    public String toString() {
        return "AvaiableFlight{" +
                "id=" + id +
                ", date_time=" + date_time +
                ", price=" + price +
                ", flight_number='" + flight_number + '\'' +
                ", airports=" + airports +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvaiableFlight that = (AvaiableFlight) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(date_time, that.date_time)) return false;
        if (!Objects.equals(price, that.price)) return false;
        if (!Objects.equals(flight_number, that.flight_number))
            return false;
        return Objects.equals(airports, that.airports);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date_time != null ? date_time.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (flight_number != null ? flight_number.hashCode() : 0);
        result = 31 * result + (airports != null ? airports.hashCode() : 0);
        return result;
    }
}
