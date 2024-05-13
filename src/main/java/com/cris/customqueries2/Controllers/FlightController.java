package com.cris.customqueries2.Controllers;

import com.cris.customqueries2.Entities.Flight;
import com.cris.customqueries2.Entities.FlightStatuus;
import com.cris.customqueries2.Services.FlightService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/create-flights")
    public List<Flight> createFlights(@RequestParam(name = "n", required = false, defaultValue = "100") int count) {
        return flightService.createFlights(count);
    }

    @GetMapping("/all-flights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/by-status")
    public List<Flight> getFlightsByStatus(@RequestParam("status") FlightStatuus status) {
        return flightService.getFlightsByStatus(status);
    }

    @GetMapping("/paginate")
    public Page<Flight> getPaginatedFlights(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return flightService.getPaginatedFlights(pageable);
    }

    @GetMapping("/ontime-flights")
    public List<Flight> getOnTimeFlights() {
        return flightService.getFlightsByStatus(FlightStatuus.ONTIME);
    }

    @GetMapping("/custom-query")
    public List<Flight> getCustomQuery(@RequestParam("p1") FlightStatuus p1, @RequestParam("p2") FlightStatuus p2) {
        return flightService.getCustomQuery(p1, p2);
    }
}
