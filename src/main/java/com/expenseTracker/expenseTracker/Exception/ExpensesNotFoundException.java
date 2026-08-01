package com.expenseTracker.expenseTracker.Exception;

public class ExpensesNotFoundException extends RuntimeException {
    public ExpensesNotFoundException(String string){
        super(string);
    }

}
