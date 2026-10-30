package com.example.Purrvision.controller;

import com.example.Purrvision.model.Booking;
import com.example.Purrvision.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/bookings")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/bookings/{id}")
    public Booking getBookingById(@PathVariable UUID id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/bookings/{id}")
    public Booking updateBooking(@RequestBody Booking booking, @PathVariable UUID id) {
        return bookingService.updateBooking(booking, id);
    }

    @DeleteMapping("/bookings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookingById( @PathVariable UUID id) {
        bookingService.deleteBookingById(id);
    }
}


