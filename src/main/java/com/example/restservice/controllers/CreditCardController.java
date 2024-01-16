package com.example.restservice.controllers;

import com.example.restservice.models.CreditCard;
import com.example.restservice.services.CreditCardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet/")
public class CreditCardController {

    @Autowired
    private CreditCardService service;

    @GetMapping
    public List<CreditCard> getAllCreditCards() {
        return service.getAll();
    }

    @GetMapping("/id/{id}")
    public CreditCard getCreditCardById(@PathVariable Integer id) {
        return service.getCreditCardById(id);
    }

    @GetMapping("/{cardNumber}")
    public CreditCard getCreditCardByCardNumber(@PathVariable String cardNumber) {
        return service.getCreditCardByCardNumber(cardNumber);
    }

}
