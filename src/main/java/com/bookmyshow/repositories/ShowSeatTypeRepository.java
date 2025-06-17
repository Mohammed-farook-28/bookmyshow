package com.bookmyshow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.models.Show;
import com.bookmyshow.models.ShowSeatType;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType , Long> {

    
    List<ShowSeatType> findAllByShow(Show show);
}
