package com.example.restservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Data @Entity
public class CreditCard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @NotBlank
    private String cardNumber;

    @NotBlank
    private String cardHolder;

    @NotBlank
    private String cardExpirationDate;

    public CreditCard cardNumber(String cardNumber) {
        setCardNumber(cardNumber);
        return this;
    }

    public CreditCard cardHolder(String cardHolder) {
        setCardHolder(cardHolder);
        return this;
    }

    public CreditCard cardExpirationDate(String cardExpirationDate) {
        setCardExpirationDate(cardExpirationDate);
        return this;
    }

}
