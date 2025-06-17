package com.bookmyshow.services.price;

import java.util.List;

import com.bookmyshow.models.ShowSeat;


public interface PriceCalculationService {
    public double calculatePrice(List<ShowSeat> showSeat);
}
