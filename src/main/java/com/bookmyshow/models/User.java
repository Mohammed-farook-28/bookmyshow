package com.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class User extends BaseModel{
    private String email ;
    private String name ;
    private String password;

    @OneToMany
    private List<Booking> bookings;
}

