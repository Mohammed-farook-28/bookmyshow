package com.bookmyshow.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.dtos.CreateBookingRequestDto;
import com.bookmyshow.dtos.CreateBookingResponseDto;
import com.bookmyshow.models.Booking;
import com.bookmyshow.models.enums.ResponseStatus;
import com.bookmyshow.services.booking.BookingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    @PostMapping("/book")
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto){
             CreateBookingResponseDto responseDto =  new CreateBookingResponseDto();
        try{
            Booking booking =  bookingService.createBooking(
                requestDto.getUserId(),
                requestDto.getShowId(),
                requestDto.getShowSeatId()
            );
            responseDto.setBooking(booking);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
       return responseDto;
    }
}
