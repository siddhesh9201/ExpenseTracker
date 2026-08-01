package com.expenseTracker.expenseTracker.Service;


import com.expenseTracker.expenseTracker.Dto.ExpenseRequestDto;
import com.expenseTracker.expenseTracker.Exception.CategoryNotFoundException;
import com.expenseTracker.expenseTracker.Exception.ExpensesNotFoundException;
import com.expenseTracker.expenseTracker.Model.Expense;
import com.expenseTracker.expenseTracker.Repository.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ExpenseTrackerService {
     private long id=1L;

    private final Repository repository;
    private final List<Expense> list;

    public ExpenseTrackerService(Repository repository) {
        this.repository = repository;
        this.list = repository.getDB();
    }
     public Expense addExpense(ExpenseRequestDto expense){
         Expense expenseEntity = new Expense();
         expenseEntity.setId(id++);
         expenseEntity.setDate(LocalDate.now());
         expenseEntity.setCategory(expense.getCategory());
         expenseEntity.setTitle(expense.getTitle());
         expenseEntity.setAmount(expense.getAmount());

         list.add(expenseEntity);
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
             if(expense.getId().equals(id)){
                 list.remove(expense);
                 return "Expense Deleted Successfully!";
             }
         }
         return "Expense not found with id " + id ;
   }
  public Expense getExpenseByCategory(String category){
      for(Expense expense : list){
          if(expense.getCategory().equals(category)){
              return expense;
          }
      }

      throw new CategoryNotFoundException("Expense Not found with id "+ category);

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
                  map.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount()
          );
      });
  return map;
  }

}
