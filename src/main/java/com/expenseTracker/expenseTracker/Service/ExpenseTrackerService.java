package com.expenseTracker.expenseTracker.Service;


import com.expenseTracker.expenseTracker.Exception.CategoryNotFoundException;
import com.expenseTracker.expenseTracker.Exception.ExpensesNotFoundException;
import com.expenseTracker.expenseTracker.Model.Expense;
import jdk.jfr.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseTrackerService {

     List<Expense> list = new ArrayList<>();

     public Expense addExpense(Expense expense){
         list.add(expense);
         return list.get(list.size()-1);
     }

     public List<Expense> viewAllExpenses() {
         if(list.isEmpty()){
             throw new ExpensesNotFoundException("Expenses Not Found!");
         }else{

             return list;

         }

     }

   public String deleteExpenseById(Long id){
         for(Expense expense : list){
             if(expense.getId()==id){
                 list.remove(id);
                 return "Expense Deleted Successfully!";
             }
         }
         return "Expense Not Exist For This" + id ;
   }
  public Expense getExpenseByCategory(String category){
      for(Expense expense : list){
          if(expense.getCategory().equals(category)){
              return expense;
          }
      }

      throw new CategoryNotFoundException("Expense Not found for "+ category);

  }


  public double findTotalExpense(){
         double sum=0;
      if(list.isEmpty()){
          throw new ExpensesNotFoundException("Expenses Not Available!");
      }

      for(Expense expense: list){
             sum+=expense.getAmount();
      }
         return sum;
  }

  public Map<String,Double> findCategoryWiseTotal(){
      Map<String,Double> map = new HashMap<>();

      if(list.isEmpty()){
         throw new ExpensesNotFoundException("Expenses not Available!");
      }
      list.stream().forEach(expense -> {
          map.put(
                  expense.getCategory(),
                  map.getOrDefault(expense.getCategory(), expense.getAmount()) + expense.getAmount()
          );
      });
  return map;
  }

}
