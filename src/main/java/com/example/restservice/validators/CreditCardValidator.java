package com.example.restservice.validators;

import com.example.restservice.exceptions.InvalidCreditCardException;
import com.example.restservice.models.CreditCard;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class CreditCardValidator {

    private static final int CREDIT_CARD_NUMBER_LENGTH = 16;
    private static final String CREDIT_CARD_EXPIRATION_DATE_FORMAT = "MM/yy";

    public static void throwIfCardNumberIsInvalid(String cardNumber) {
        if (!cardNumber.matches("[0-9]+")) {
            throw new InvalidCreditCardException("cardNumber must be numerical");
        }

        if (cardNumber.length() != CREDIT_CARD_NUMBER_LENGTH) {
            throw new InvalidCreditCardException("cardNumber must have exactly 16 numbers");
        }
    }

    public static void throwIfCardHolderIsInvalid(String cardHolder) {
        if (!cardHolder.matches("[a-zA-Z ]+")) {
            throw new InvalidCreditCardException("cardHolder must have alphabet letters only");
        }
    }

    public static void throwIfExpirationDateIsInvalid(String cardExpirationDate) {
        try {
            YearMonth yearMonthExpiration = YearMonth.parse(cardExpirationDate, DateTimeFormatter.ofPattern(CREDIT_CARD_EXPIRATION_DATE_FORMAT));
            LocalDate localDateExpiration = yearMonthExpiration.atDay(yearMonthExpiration.atEndOfMonth().getDayOfMonth());
            boolean expired = localDateExpiration.isBefore(LocalDate.now());
            if (expired) {
                throw new InvalidCreditCardException("CreditCard is expired");
            }
        } catch (DateTimeParseException e) {
            throw new InvalidCreditCardException("Failed to parse expirationDate, must be \"MM/yy\"");
        }
    }

    public static void throwIfCreditCardIsInvalid(CreditCard creditCard) {
        throwIfCardNumberIsInvalid(creditCard.getCardNumber());
        throwIfExpirationDateIsInvalid(creditCard.getCardExpirationDate());
    }

}
