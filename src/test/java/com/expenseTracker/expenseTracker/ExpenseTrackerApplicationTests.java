package com.expenseTracker.expenseTracker;

import com.expenseTracker.expenseTracker.Dto.ExpenseRequestDto;
import com.expenseTracker.expenseTracker.Model.Expense;
import com.expenseTracker.expenseTracker.Service.ExpenseTrackerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpenseTrackerApplicationTests {
	@Autowired
   private ExpenseTrackerService expenseTrackerService;
	@Test
	void shouldAddExpense() {
		ExpenseRequestDto dto = new ExpenseRequestDto();
		dto.setTitle("Lunch");
		dto.setAmount(200.0);
		dto.setCategory("Food");

		Expense expense = expenseTrackerService.addExpense(dto);

		assertEquals("Lunch", expense.getTitle());
		assertEquals(200.0, expense.getAmount());
	}

	@Test
	void shouldReturnAllExpenses() {

		List<Expense> expenses = expenseTrackerService.viewAllExpenses();

		assertFalse(expenses.isEmpty());
	}
	@Test
	void shouldDeleteExpense() {

		String result = expenseTrackerService.deleteExpenseById(1L);

		assertEquals("Expense Deleted Successfully!", result);
	}

	@Test
	void shouldCalculateTotalExpense() {

		double total = expenseTrackerService.findTotalExpense();

		assertTrue(total > 0);
	}
}
