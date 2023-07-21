package com.ademozalp.ParkEt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class ParkEtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkEtApplication.class, args);
    }

}
