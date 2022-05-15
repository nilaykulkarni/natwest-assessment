package com.natwest.assessment.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Service to return prime numbers including and up to given input
 */
@Service
public class PrimeNumberService {
    public List<Integer> findPrimeNumbers(Integer input) {
        return IntStream.rangeClosed(2, input).filter(i -> isPrime(i)).boxed().collect(Collectors.toList());
    }

    private boolean isPrime(Integer i) {
        return IntStream.range(2, i).noneMatch(n -> i%n==0);
    }
}
