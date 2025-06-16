package com.bookmyshow.models;

import com.bookmyshow.models.enums.PaymentStatus;
import com.bookmyshow.models.enums.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    private double paymentAmount ;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus; 
    
    private String referenceId;

}
