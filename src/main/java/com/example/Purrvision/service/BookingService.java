package com.example.Purrvision.service;

//LOGIKEN/REGLERNA - bestämmer hur saker ska gå till.
// T.ex. ny bokning = PENDING, bokningen finns inte = säg det.

import com.example.Purrvision.model.Booking;
import com.example.Purrvision.model.BookingStatus;
import com.example.Purrvision.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

//LOGIKEN/REGLERNA - bestämmer hur saker ska gå till. T.ex. ny bokning = PENDING, bokningen finns inte = 404.

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

    public Booking getBookingById(UUID id) {
        return bookingRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Booking updateBooking(Booking booking, UUID id) {
       Booking existing = getBookingById(id);
       existing.setName(booking.getName());
       existing.setEmail(booking.getEmail());
       existing.setMovieTitle(booking.getMovieTitle());
       existing.setDateTime(booking.getDateTime());
       existing.setNumberOfPeople(booking.getNumberOfPeople());
       existing.setStatus(booking.getStatus());
    return bookingRepository.save(existing);
    }

    public void deleteBookingById(UUID id) {
        getBookingById(id);
        bookingRepository.deleteById(id);
    }
}
