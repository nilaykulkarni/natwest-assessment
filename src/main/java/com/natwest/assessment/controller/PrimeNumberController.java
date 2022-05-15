package com.natwest.assessment.controller;

import com.natwest.assessment.model.InputRequest;
import com.natwest.assessment.service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
Rest controller with one POST method to receive input from client and return response by calling service
 */
@RestController
public class PrimeNumberController {
    @Autowired
    PrimeNumberService primeNumberService;

    @PostMapping(value = "/prime")
    public ResponseEntity<Object> primeNumbers(@RequestBody @Validated InputRequest inputRequest) {
        if(inputRequest.getInput()<2) {
            return new ResponseEntity<>("Please enter a value above 1...", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(getPrimeNumbers(inputRequest.getInput()), HttpStatus.OK);
    }

    private List<Integer> getPrimeNumbers(Integer input) {
        return primeNumberService.findPrimeNumbers(input);
    }
}
