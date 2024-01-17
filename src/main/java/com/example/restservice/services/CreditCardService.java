package com.example.restservice.services;

import com.example.restservice.models.CreditCard;
import com.example.restservice.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository repository;

    public Iterable<CreditCard> getAll() {
        return repository.findAll();
    }

    public CreditCard getCreditCardById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public CreditCard getCreditCardByCardNumber(String cardNumber) {
        return repository.findByCardNumber(cardNumber);
    }

    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
