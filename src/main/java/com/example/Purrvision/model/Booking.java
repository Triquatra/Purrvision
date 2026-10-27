package com.example.Purrvision.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

//BESKRIVER EN BOKNING - blir tabellen "bookings" i databasen. Varje fält = en kolumn.

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }
}
