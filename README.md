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

## Running the Project

This project includes the Maven Wrapper, so a separate Maven installation is not required.

## Start the application

Using Maven Wrapper (recommended):

./mvnw.cmd spring-boot:run

## Run the test suite

Using Maven Wrapper:

./mvnw.cmd test

If Maven is installed globally on your system, you can also use:

mvn spring-boot:run

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
