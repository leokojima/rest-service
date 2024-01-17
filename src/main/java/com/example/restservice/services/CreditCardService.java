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
    private CreditCardRepository repo;

    public Iterable<CreditCard> getAll() {
        return repo.findAll();
    }

    public CreditCard getCreditCardById(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    public CreditCard getCreditCardByCardNumber(String cardNumber) {
        return repo.findByCardNumber(cardNumber);
    }

    public CreditCard create(CreditCard creditCard) {
        if (repo.existsByCardNumber(creditCard.getCardNumber())) {
            throw new CreditCardAlreadyExistsException(String.format("CreditCard already exists with cardNumber: %s", creditCard.getCardNumber()));
        } else {
            return repo.save(creditCard);
        }
    }

    public CreditCard update(Integer id, CreditCard creditCard) {
        CreditCard creditCardInDb = getCreditCardById(id);
        creditCardInDb.setCardNumber(creditCard.getCardNumber());
        creditCardInDb.setCardHolder(creditCard.getCardHolder());
        creditCardInDb.setCardExpirationDate(creditCard.getCardExpirationDate());
        return repo.save(creditCardInDb);
    }

    public void deleteById(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new CreditCardNotFoundException(String.format("CreditCard not found with id: %s", id));
        }
    }

}
