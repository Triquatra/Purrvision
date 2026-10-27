package com.example.Purrvision.service;

//LOGIKEN - tex om bokningen inte finns gör så.

import com.example.Purrvision.model.Booking;
import com.example.Purrvision.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
