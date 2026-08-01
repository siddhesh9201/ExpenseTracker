# ExpenseTracker

## Overview
A REST API built using Spring Boot to manage personal expenses.

## Features
- Add Expense
- View All Expenses
- Filter by Category
- Category wise total Expense
- Calculate Total Expenses
- Delete Expense
- Swagger API Documentation

## Tech Stack
- Java 21
- Spring Boot
- Maven
- JUnit 5
- Swagger (OpenAPI)

## Run the Application

mvn spring-boot:run


## Run Tests

mvn test

## API Endpoints

 POST :/expenses/add
 GET : /expenses/get 
 GET : /expenses/getByCategory/{category} 
 GET : /expenses/total 
 Get : /category/total
DELETE :/expenses/delete/{id}

## Swagger
http://localhost:8080/swagger-ui/index.html
