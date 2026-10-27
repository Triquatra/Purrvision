package com.example.Purrvision.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String movieTitle;
    private LocalDateTime dateTime;
    private int numberOfPeople;
    // spara som string för att kunna se i databasen vad våra enums betyder
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

}
