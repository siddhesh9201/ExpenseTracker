package com.expenseTracker.expenseTracker.Repository;

import com.expenseTracker.expenseTracker.Model.Expense;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    List<Expense> list = new ArrayList<>();


    public List getDB() {
        return list;
    }


}