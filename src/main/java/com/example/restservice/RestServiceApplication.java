package com.example.restservice;

import com.example.restservice.models.CreditCard;
import com.example.restservice.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}

//Just to print what is already in db
@Component
class CreditCardCommandLineRunner implements CommandLineRunner {

    @Autowired CreditCardRepository creditCardRepository;

    @Override
    public void run(String... args) throws Exception {

        for (CreditCard c : creditCardRepository.findAll())
            System.out.println(c.toString());
    }

}
