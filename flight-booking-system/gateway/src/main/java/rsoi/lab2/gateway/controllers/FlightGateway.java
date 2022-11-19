package rsoi.lab2.gateway.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import rsoi.lab2.gateway.requests.PurchaseTicketRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1")
public class FlightGateway {

    @Value("${services.urls.flight-service-url}")
    private String flightServiceUrl;

    @Value("${services.urls.privilege-service-url}")
    private String privilegeServiceUrl;

    @Value("${services.urls.tickets-service-url}")
    private String ticketsServiceUrl;

    @GetMapping("/flights")
    public ResponseEntity<Object> findAllFlights(@RequestParam int page,
                                                 @RequestParam int size) {
        String url = UriComponentsBuilder.fromHttpUrl(flightServiceUrl)
                .queryParam("page", page)
                .queryParam("size", size)
                .toUriString();

        return getResponseEntity(url);
    }

    @GetMapping("/privilege")
    public ResponseEntity<Object> findPrivilege() {
        String url = UriComponentsBuilder.fromHttpUrl(privilegeServiceUrl).toUriString();

        return getResponseEntity(url);
    }

    @PostMapping("/tickets")
    public ResponseEntity<Object> purchaseTicket(@RequestBody PurchaseTicketRequest request) {
        if (isFlightExists(request)) {
            String url = UriComponentsBuilder.fromHttpUrl(ticketsServiceUrl).toUriString();

            Map<String, String> map = new HashMap<>();
            map.put("flightNumber", request.getFlightNumber());
            map.put("price", request.getPrice() + "");
            map.put("paidFromBalance", request.getPaidFromBalance() + "");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>(map, headers);
            RestOperations restOperations = new RestTemplate();

            return restOperations.postForEntity(
                    url,
                    entity,
                    Object.class
            );
        }

        throw new IllegalArgumentException("Flight Number Doesn't Exists");
    }

    private Boolean isFlightExists(PurchaseTicketRequest request) {
        String url = UriComponentsBuilder.fromHttpUrl(flightServiceUrl + "/isExists")
                .queryParam("flightNumber", request.getFlightNumber())
                .toUriString();

        return Boolean.parseBoolean(Objects.requireNonNull(getResponseEntity(url).getBody()).toString());
    }

    private ResponseEntity<Object> getResponseEntity(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestOperations restOperations = new RestTemplate();

        return restOperations.exchange(
                url,
                HttpMethod.GET,
                entity,
                Object.class
        );
    }
}
