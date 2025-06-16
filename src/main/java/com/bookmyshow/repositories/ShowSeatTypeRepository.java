package com.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.models.ShowSeatType;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType , Long> {
}
