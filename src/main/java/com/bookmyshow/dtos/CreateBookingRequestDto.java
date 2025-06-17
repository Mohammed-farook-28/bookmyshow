package com.bookmyshow.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingRequestDto {

    private Long userId;
    private List<Long> showSeatId;
    private Long showId;
}
