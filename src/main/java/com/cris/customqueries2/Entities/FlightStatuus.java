package com.cris.customqueries2.Entities;

public enum FlightStatuus {
    ONTIME, DELAYED, CANCELLED;


    public static FlightStatuus toString(String status) {
        return switch (status.toLowerCase()) {
            case "delayed" -> FlightStatuus.DELAYED;
            case "cancelled" -> FlightStatuus.CANCELLED;
            default -> FlightStatuus.ONTIME;
        };


    }
}