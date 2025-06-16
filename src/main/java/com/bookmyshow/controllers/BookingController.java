package com.bookmyshow.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.dtos.CreateBookingRequestDto;
import com.bookmyshow.dtos.CreateBookingResponseDto;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    
    @PostMapping("/book")
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto){
        return null;
    }
}
