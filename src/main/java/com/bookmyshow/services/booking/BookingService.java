package com.bookmyshow.services.booking;

import java.util.List;

import com.bookmyshow.dtos.CreateBookingResponseDto;

public interface BookingService {
    public CreateBookingResponseDto createBooking(Long userId , Long ShowId , List<Long> showSeatId);
}
