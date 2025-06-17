package com.bookmyshow.services.booking;

import java.util.List;

import com.bookmyshow.models.Booking;

public interface BookingService {
    public Booking createBooking(Long userId , Long ShowId , List<Long> showSeatId);
}
