package com.example.restservice.services;

import com.example.restservice.models.CreditCard;
import com.example.restservice.repositories.CreditCardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository repository;

    public List<CreditCard> getAll() {
        return repository.findAll();
    }

    public CreditCard getCreditCardById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public CreditCard getCreditCardByCardNumber(String cardNumber) {
        return repository.findByCardNumber(cardNumber);
    }

    public CreditCard getCreditCardByCardHolder(String cardHolder) {
        return repository.findByCardNumber(cardHolder);
    }

}
