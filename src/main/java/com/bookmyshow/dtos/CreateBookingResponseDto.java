package com.bookmyshow.dtos;

import com.bookmyshow.models.Booking;
import com.bookmyshow.models.enums.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;
    
}
