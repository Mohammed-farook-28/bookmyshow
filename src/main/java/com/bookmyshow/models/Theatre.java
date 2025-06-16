package com.bookmyshow.models;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel{
    private String name ;
    private String address;

    @OneToMany
    private List<Screen> screens;

    @ManyToOne
    private City city ;
}