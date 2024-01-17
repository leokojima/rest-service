package com.example.restservice.repositories;

import com.example.restservice.models.CreditCard;
import org.springframework.data.repository.CrudRepository;

public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

    boolean existsByCardNumber(String cardNumber);

    CreditCard findByCardNumber(String cardNumber);

}
