package com.expenseTracker.expenseTracker.Exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ExpensesNotFoundException.class)
    public ResponseEntity<String> exception1(ExpensesNotFoundException ex){
        return ResponseEntity.ok(ex.getMessage());
    }

}
