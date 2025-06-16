package com.bookmyshow.services.booking.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bookmyshow.dtos.CreateBookingResponseDto;
import com.bookmyshow.models.Show;
import com.bookmyshow.models.ShowSeat;
import com.bookmyshow.models.User;
import com.bookmyshow.models.enums.ShowSeatStatus;
import com.bookmyshow.repositories.ShowRepository;
import com.bookmyshow.repositories.ShowSeatRepository;
import com.bookmyshow.repositories.UserRepository;
import com.bookmyshow.services.booking.BookingService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements  BookingService{
    private final UserRepository userRepo;
    private final ShowRepository showRepo;
    private final ShowSeatRepository showSeatRepo;
    private final ShowSeatRepository showSeatTypeRepo;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public CreateBookingResponseDto createBooking(Long userId, Long showId, List<Long> showSeatId) {

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
                throw new RuntimeException("Show Seat Id : " + showSeat.getId() + " does not belong to Show Id : " + showId);
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
        }


        

        return null;

    }

}
