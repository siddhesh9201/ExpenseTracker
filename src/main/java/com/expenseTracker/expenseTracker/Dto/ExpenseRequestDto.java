package com.expenseTracker.expenseTracker.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class ExpenseRequestDto {

    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private Double amount;
    @NotBlank(message = "Category cannot be blank")
    private String category;

    public @NotBlank(message = "Title cannot be blank") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title cannot be blank") String title) {
        this.title = title;
    }

    public @NotNull(message = "Amount is required") @Positive(message = "Amount must be greater than 0") Double getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "Amount is required") @Positive(message = "Amount must be greater than 0") Double amount) {
        this.amount = amount;
    }

    public @NotBlank(message = "Category cannot be blank") String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank(message = "Category cannot be blank") String category) {
        this.category = category;
    }
}
