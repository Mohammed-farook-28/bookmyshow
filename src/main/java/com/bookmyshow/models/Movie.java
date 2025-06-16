package com.bookmyshow.models;


import java.util.List;

import com.bookmyshow.models.enums.Feature;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name ;

    @ManyToMany
    List<Language> languages;
    
    @ManyToMany
    List<Actor> actors;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    List<Feature> features;
}
