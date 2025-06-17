package com.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
