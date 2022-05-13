package com.natwest.assessment.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PrimeNumberServiceTest {

    @Autowired
    PrimeNumberService primeNumberService;

    @Test
    public void givenInputInteger_whenPrimeNumberServiceCalled_thenReturnList() {
        List<Integer> primeNumbers = Arrays.asList(2,3,5,7);
        Assertions.assertEquals(primeNumberService.findPrimeNumbers(10), primeNumbers);
    }
}