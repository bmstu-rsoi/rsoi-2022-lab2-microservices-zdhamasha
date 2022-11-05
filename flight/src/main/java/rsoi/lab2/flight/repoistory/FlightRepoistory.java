package rsoi.lab2.flight.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rsoi.lab2.flight.model.Flight;

@Repository
public interface FlightRepoistory extends JpaRepository<Flight, Long> {
}
