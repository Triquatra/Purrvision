package com.example.Purrvision.controller;

import com.example.Purrvision.model.Booking;
import com.example.Purrvision.service.BookingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
//TAR EMOT REQUESTS - första stället en request kommer till. Skickar vidare till service och returnerar svaret.

@RestController
public class InstanceController {

    @Value("${INSTANCE_NAME:api-1}")
    private String instanceName;

    @GetMapping("/instance")
    public Map<String, String> getInstance() {
        return Map.of("instance", instanceName);
    }


    @RestController
    public class BookingController {
       private final BookingService bookingService;

        public BookingController(BookingService bookingService) {
            this.bookingService = bookingService;
        }

        @GetMapping("/bookings")
        public List<Booking> getAllBookings(){
            return bookingService.getAllBookings();
        }
    }
}
