package com.example.restservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "CreditCard already exist")
public class CreditCardAlreadyExistsException extends RuntimeException {

    public CreditCardAlreadyExistsException(String message) {
        super(message);
    }

}
