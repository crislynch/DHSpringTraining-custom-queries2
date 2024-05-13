package com.cris.customqueries2.Repositories;

import com.cris.customqueries2.Entities.Flight;
import com.cris.customqueries2.Entities.FlightStatuus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightResporitory extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(FlightStatuus flightStatus);
    List<Flight> findByStatusIn(List<FlightStatuus> statuss);
}
