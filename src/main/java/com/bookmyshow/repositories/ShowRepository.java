package com.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmyshow.models.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{

}
