package com.bookmyshow.models;

import java.util.List;

import com.bookmyshow.models.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking extends BaseModel{
    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @OneToMany
    private List< ShowSeat> showSeat;
     
    private double amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

}
