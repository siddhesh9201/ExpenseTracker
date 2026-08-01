package com.expenseTracker.expenseTracker.Controller;


import com.expenseTracker.expenseTracker.Model.Expense;
import com.expenseTracker.expenseTracker.Service.ExpenseTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseTrackerController{

    @Autowired
    ExpenseTrackerService expenseTrackerService;

    @PostMapping("/add")
    public ResponseEntity<Expense> addNewExpense(@RequestBody Expense expense){
        return ResponseEntity.ok(expenseTrackerService.addExpense(expense));
    }
    public ResponseEntity
}
