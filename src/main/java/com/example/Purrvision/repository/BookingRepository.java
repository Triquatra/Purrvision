package com.example.Purrvision.repository;

import com.example.Purrvision.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//PRATAR MED DATABASEN - hämtar, sparar, tar bort. Metoderna kommer färdiga från JpaRepository.

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
