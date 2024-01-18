package com.example.restservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "CreditCard is invalid")
public class InvalidCreditCardException extends RuntimeException {

    public InvalidCreditCardException(String message) {
        super(message);
    }

}
