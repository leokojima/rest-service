package com.example.restservice.models;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private String id;

    @Getter
    @Setter
    private String cardNumber;

    @Getter
    @Setter
    private String cardHolder;

    @Getter
    @Setter
    private String cardExpirationDate;

    public CreditCard() { }

    public CreditCard(String cardNumber, String cardHolder, String cardExpirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cardExpirationDate = cardExpirationDate;
    }

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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreditCard)) {
            return false;
        }
        CreditCard creditCard = (CreditCard) o;
        return id == creditCard.id;
            // && Objects.equals(cardHolder, creditCard.cardHolder)
            // && Objects.equals(cardExpirationDate, creditCard.cardExpirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardHolder, cardExpirationDate);
    }

    @Override
    public String toString() {
        return "{" +
            " cardNumber='" + getCardNumber() + "'" +
            ", cardHolder='" + getCardHolder() + "'" +
            ", cardExpirationDate='" + getCardExpirationDate() + "'" +
            "}";
    }

}
