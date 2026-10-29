package com.example.Purrvision.service;

//LOGIKEN/REGLERNA - bestämmer hur saker ska gå till.
// T.ex. ny bokning = PENDING, bokningen finns inte = säg det.

import com.example.Purrvision.model.Booking;
import com.example.Purrvision.model.BookingStatus;
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

    public Booking createBooking(Booking booking) {
        booking.setStatus(BookingStatus.PENDING);
        return bookingRepository.save(booking);
    }
}
