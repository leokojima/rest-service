package com.example.restservice.controllers;

import com.example.restservice.models.CreditCard;
import com.example.restservice.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/creditcard/")
public class CreditCardController {

    @Autowired
    private CreditCardService service;

    @GetMapping
    public Iterable<CreditCard> getAllCreditCards() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CreditCard getCreditCardById(@PathVariable Integer id) {
        return service.getCreditCardById(id);
    }

    @GetMapping("/cardNumber/{cardNumber}")
    public CreditCard getCreditCardByCardNumber(@PathVariable String cardNumber) {
        return service.getCreditCardByCardNumber(cardNumber);
    }

    @PostMapping
    public CreditCard create(@RequestBody CreditCard creditCard) {
        return service.create(creditCard);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }

}
