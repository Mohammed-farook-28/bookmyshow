package com.bookmyshow.models;

import java.util.List;

import com.bookmyshow.models.enums.Feature;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Screen extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat>  seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
