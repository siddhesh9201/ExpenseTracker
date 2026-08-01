package com.expenseTracker.expenseTracker.Controller;


import com.expenseTracker.expenseTracker.Dto.ExpenseRequestDto;
import com.expenseTracker.expenseTracker.Model.Expense;
import com.expenseTracker.expenseTracker.Service.ExpenseTrackerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expenses")
public class ExpenseTrackerController{

    @Autowired
    ExpenseTrackerService expenseTrackerService;

    @PostMapping("/add")
    public ResponseEntity<Expense> addNewExpense(@Valid  @RequestBody ExpenseRequestDto expense){
        return ResponseEntity.ok(expenseTrackerService.addExpense(expense));
    }
    @GetMapping("/get")
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok(expenseTrackerService.viewAllExpenses());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable long id){
        return ResponseEntity.ok(expenseTrackerService.deleteExpenseById(id));
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotal(){
        return ResponseEntity.ok(expenseTrackerService.findTotalExpense());
    }


    @GetMapping("/getByCategory/{category}")
    public ResponseEntity<Expense> getCategoryById(@PathVariable String category){
        return ResponseEntity.ok(expenseTrackerService.getExpenseByCategory(category));
    }

    @GetMapping("/category/total")
    public ResponseEntity<Map<String,Double>> getCategoryWiseTotal(){
        return ResponseEntity.ok(expenseTrackerService.findCategoryWiseTotal());
    }
}
