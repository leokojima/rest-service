package com.example.restservice.services;

import com.example.restservice.exceptions.CreditCardAlreadyExistsException;
import com.example.restservice.exceptions.CreditCardNotFoundException;
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

    public CreditCard create(CreditCard creditCard) {
        if (repository.existsByCardNumber(creditCard.getCardNumber())) {
            throw new CreditCardAlreadyExistsException(String.format("CreditCard already exists with cardNumber: %s", creditCard.getCardNumber()));
        } else {
            return repository.save(creditCard);
        }
    }

    public void deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new CreditCardNotFoundException(String.format("CreditCard not found with id: %s", id));
        }
    }

}
