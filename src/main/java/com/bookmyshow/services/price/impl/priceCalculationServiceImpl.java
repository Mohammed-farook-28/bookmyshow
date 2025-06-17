package com.bookmyshow.services.price.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookmyshow.models.ShowSeat;
import com.bookmyshow.models.ShowSeatType;
import com.bookmyshow.repositories.ShowSeatTypeRepository;
import com.bookmyshow.services.price.PriceCalculationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceCalculationServiceImpl implements  PriceCalculationService{
    public final ShowSeatTypeRepository showSeatTypeRepo;

    @Override
    public double calculatePrice(List<ShowSeat> showSeats) {
        List<ShowSeatType>  showSeatTypes =  showSeatTypeRepo.findAllByShow(showSeats.get(0).getShow());

        double price = 0;
        for(ShowSeat showSeat : showSeats){
            for(ShowSeatType  showSeatType : showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    price+=showSeatType.getPrice();
                }
            }
        }
        return  price;
    }

}
