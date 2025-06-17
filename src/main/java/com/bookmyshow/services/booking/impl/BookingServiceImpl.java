package com.bookmyshow.services.booking.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bookmyshow.models.Booking;
import com.bookmyshow.models.Show;
import com.bookmyshow.models.ShowSeat;
import com.bookmyshow.models.User;
import com.bookmyshow.models.enums.BookingStatus;
import com.bookmyshow.models.enums.ShowSeatStatus;
import com.bookmyshow.repositories.ShowRepository;
import com.bookmyshow.repositories.ShowSeatRepository;
import com.bookmyshow.repositories.UserRepository;
import com.bookmyshow.services.booking.BookingService;
import com.bookmyshow.services.price.PriceCalculationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements  BookingService{
    private final UserRepository userRepo;
    private final ShowRepository showRepo;
    private final ShowSeatRepository showSeatRepo;
    private final PriceCalculationService priceCalculationService;


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, Long showId, List<Long> showSeatId) {

        Optional<User> optionalUser  = userRepo.findById(userId);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User Id : " +userId +"Not Found");
        }
        

        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepo.findById(showId);
        if(optionalShow.isEmpty()){
            throw new RuntimeException("ShowId : " + showId +"Not Found");
        }

        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepo.findAlllById(showSeatId);
       
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("Seats are Unavailable !");
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepo.save(showSeat);
        }

        Booking booking =  new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeat(showSeats);
        booking.setAmount(priceCalculationService.calculatePrice(showSeats));

        
        return booking;

    }

}
