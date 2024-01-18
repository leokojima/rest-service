package com.example.restservice.repositories;

import com.example.restservice.models.CreditCard;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ICreditCardRepository extends CrudRepository<CreditCard, Integer> {

    boolean existsByCardNumber(String cardNumber);

    Optional<CreditCard> findByCardNumber(String cardNumber);

}
