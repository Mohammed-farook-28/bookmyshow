package com.bookmyshow.models;

import java.util.Date;
import java.util.List;

import com.bookmyshow.models.enums.Feature;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "shows")
@Getter
@Setter
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theatre theatre;

    @OneToOne
    private Screen screen;
    private Date startTime;
    private Date EndTime;

    @ManyToOne
    private Language language ;
    
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
