package com.expenseTracker.expenseTracker.Exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String s){
        super(s);
    }
}
