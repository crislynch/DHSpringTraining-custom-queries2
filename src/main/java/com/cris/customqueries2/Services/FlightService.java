package com.cris.customqueries2.Services;


import com.cris.customqueries2.Entities.Flight;
import com.cris.customqueries2.Entities.FlightStatuus;
import com.cris.customqueries2.Repositories.FlightResporitory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class FlightService {

    @Autowired
    FlightResporitory flightRepository;

    public List<Flight> createFlights(int count) {
        Random random = new Random();
        List<Flight> flights = IntStream.range(0, count)
                .mapToObj(i -> {
                    Flight flight = new Flight();
                    flight.setDescription("Flight " + i);
                    flight.setDeparture(generateAirportCode());
                    flight.setArrival(generateAirportCode());
                    flight.setStatus(FlightStatuus.values()[random.nextInt(FlightStatuus.values().length)]);
                    return flight;
                })
                .collect(Collectors.toList());
        return flightRepository.saveAll(flights);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    private String generateAirportCode() {
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    public List<Flight> getFlightsByStatus(FlightStatuus status) {
        return flightRepository.findByStatus(status);
    }

    public Page<Flight> getPaginatedFlights(Pageable pageable) {
        return flightRepository.findAll(pageable);
    }

    public List<Flight> getCustomQuery(FlightStatuus p1, FlightStatuus p2) {
        return flightRepository.findByStatusIn(List.of(p1, p2));
    }
}
