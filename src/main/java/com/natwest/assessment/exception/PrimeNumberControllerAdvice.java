package com.natwest.assessment.exception;

import com.natwest.assessment.controller.PrimeNumberController;
import com.natwest.assessment.model.InputRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PrimeNumberControllerAdvice {

    Logger logger = LoggerFactory.getLogger(PrimeNumberControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(HttpServletRequest request, Exception exception) {
        logger.error("Exception caught " + exception.getMessage());
        return new ResponseEntity<>(" Please enter a valid input..." , HttpStatus.BAD_REQUEST);
    }

}
