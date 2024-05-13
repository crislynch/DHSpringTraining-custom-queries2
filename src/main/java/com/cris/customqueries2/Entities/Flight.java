package com.cris.customqueries2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "description")
    private String description;
    @Column(nullable = false, name = "departurre")
    private String departure;
    @Column(nullable = false, name = "arrival")
    private String arrival;


    @Enumerated(EnumType.STRING)
    private FlightStatuus status = FlightStatuus.ONTIME;
}
