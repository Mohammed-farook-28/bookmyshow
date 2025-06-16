package com.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Actor extends BaseModel{
    private String name ;

    @ManyToMany
    private List<Movie> moviesActed;
    
}
