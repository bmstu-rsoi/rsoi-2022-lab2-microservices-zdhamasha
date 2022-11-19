package rsoi.lab2.ticket.responses;

import rsoi.lab2.ticket.model.Status;

import java.sql.Timestamp;
import java.util.UUID;

public class PurchaseFlightResponse {

    private String flightNumber; // flight
    private UUID ticketUid; // flight
    private String fromAirport; // flight
    private String toAirport; // flight
    private Timestamp date;  // flight
    private Integer price; // ticket
    private Integer paidByMoney; // ticket
    private Integer paidByBonuses; // ticket
    private Status status; // ticket
//private Privilege privilege; balance + status
}
