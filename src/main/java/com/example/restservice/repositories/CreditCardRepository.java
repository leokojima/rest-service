package com.example.restservice.repositories;

import com.example.restservice.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

    CreditCard findByCardNumber(String cardNumber);

    CreditCard findByCardHolder(String cardHolder);

}
