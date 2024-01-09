package com.example.sb.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //allows handling exceptions across the whole application in one global handling component.
public class RestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(StudentNotFoundException exc) {
        ErrorResponse err = new ErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllException(Exception exc) {
        ErrorResponse err = new ErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
