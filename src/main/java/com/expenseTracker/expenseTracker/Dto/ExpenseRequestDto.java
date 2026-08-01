package com.expenseTracker.expenseTracker.Dto;

import java.time.LocalDate;

public class ExpenseRequestDto {


    private String title;
    private Double amount;
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
