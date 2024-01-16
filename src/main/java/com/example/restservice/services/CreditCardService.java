package com.example.restservice.services;

import com.example.restservice.models.CreditCard;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    private static List<CreditCard> REPOSITORY_CC = new ArrayList<>();

    static {
        REPOSITORY_CC.add(new CreditCard("1234123412341234", "LeoTK", "12/23"));
        REPOSITORY_CC.add(new CreditCard("2222222222222222", "LeoTK", "12/23"));
        REPOSITORY_CC.add(new CreditCard("3333333333333333", "LeoTK", "12/23"));
        REPOSITORY_CC.add(new CreditCard("4444444444444444", "LeoTK", "12/23"));
        REPOSITORY_CC.add(new CreditCard("5555555555555555", "LeoTK", "12/23"));
    }

    public List<CreditCard> getAll() {
        return REPOSITORY_CC;
    }

    public CreditCard getCreditCardById(Integer id) {
        return REPOSITORY_CC.stream()
            .filter(cc -> id.equals(cc.getId()))
            .findFirst()
            .orElse(null);
    }

    public CreditCard getCreditCardByCardNumber(String cardNumber) {
        return REPOSITORY_CC.stream()
            .filter(cc -> cardNumber.equals(cc.getCardNumber()))
            .findFirst()
            .orElse(null);
    }

}
