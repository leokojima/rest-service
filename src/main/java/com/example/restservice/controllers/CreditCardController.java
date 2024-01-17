package com.example.restservice.controllers;

import com.example.restservice.models.CreditCard;
import com.example.restservice.services.CreditCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/creditcard/")
public class CreditCardController {

    @Autowired
    private CreditCardService service;

    @Operation(summary = "Get all CreditCards in db")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the CreditCard", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreditCard.class)) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @GetMapping
    public List<CreditCard> getAllCreditCards() {
        return service.getAll();
    }

    @Operation(summary = "Get a CreditCard by its id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the CreditCard", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreditCard.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "CreditCard not found", content = @Content)
    })
    @GetMapping("/{id}")
    public CreditCard getCreditCardById(@Parameter(description = "id to be searched") @PathVariable Integer id) {
        return service.getCreditCardById(id);
    }

    @Operation(summary = "Get a CreditCard by its cardNumber")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the CreditCard", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CreditCard.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid cardNumber supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "CreditCard not found", content = @Content)
    })
    @GetMapping("/cardNumber/{cardNumber}")
    public CreditCard getCreditCardByCardNumber(@Parameter(description = "cardNumber to be searched") @PathVariable String cardNumber) {
        return service.getCreditCardByCardNumber(cardNumber);
    }

}
