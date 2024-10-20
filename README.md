# Rule Engine with Abstract Syntax Tree (AST)

## Overview
The Rule Engine with Abstract Syntax Tree (AST) is a 3-tier application designed to determine user eligibility based on various attributes, including age, department, income, and spending. By leveraging the AST, the system allows for dynamic creation, combination, and modification of rules, enabling efficient rule evaluation and management.

### What is an Abstract Syntax Tree (AST)?
An AST is a hierarchical tree representation of the abstract syntactic structure of source code or expressions. In this project, it represents conditional rules, allowing for complex evaluations and logical combinations.

## Architecture
This project follows the Model-View-Controller (MVC) design pattern, which separates the application into three interconnected components:
- **Controller**: Handles incoming requests and responses.
- **Service**: Contains the business logic and rule evaluation.
- **Model**: Represents the data structure and rule representation.
- **Repository**: Interfaces with the database to store and retrieve rules and metadata.
- **Database**: H2 in-memory database for storing rules and application data.

## Dependencies
This project is a Maven-based Spring Boot application. It includes the following key dependencies:

- **Spring Web**: To build RESTful APIs for rule management.
- **Spring HATEOAS**: To enable hypermedia-driven REST APIs.
- **H2 Database**: An in-memory database for quick data storage and retrieval.
- **Spring Data JPA**: To simplify data access and interaction with the database.

### Setting Up the Project
You can run this project using any Java IDE, such as IntelliJ IDEA.

1. Clone the repository:
   ```bash
   git clone https://github.com/PRUTHVIRJ/RuleEngine.git
   cd RuleEngine

# Rule Engine Application

This repository contains a Java-based rule engine application with RESTful APIs for creating, combining, and evaluating rules.

## Getting Started

### Building and Running the Application

1. Import the project into your Java IDE.
2. Run the main application class to start the server.

## API Endpoints

The following API endpoints are available for managing rules:

### 1. Create Rule

Create a new rule by sending a string representing the rule.
```bash
POST http://localhost:8081/api/rules/create Content-Type: text/plain
Body: age = 40 AND salary > 30000
\

Description: This API takes a rule string and returns the corresponding Abstract Syntax Tree (AST) representation.

### 2. Combine Rules

Combine multiple rules into a single AST.
```bash
POST http://localhost:8081/api/rules/combine Content-Type: application/json
Body: [ "(age > 30 AND department = 'Sales')", "(age < 25 AND department = 'Marketing')", "(salary > 50000 OR experience > 5)" ]

Description: This API accepts a list of rule strings and returns the combined AST.

### 3. Evaluate Rule

Evaluate a specific rule against user attributes.
```bash
POST http://localhost:8081/api/rules/evaluate Content-Type: application/json
Body: { "age": "40", "salary": "31000" }

Description: This API checks if the user meets the criteria defined by the combined rule.

## Database Access

The application uses an in-memory H2 database for data storage. You can access the H2 console at:
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (leave blank)


## Test Cases

1. Create individual rules using the create_rule API and verify their AST representation.
2. Combine example rules using the combine_rules API and ensure the resulting AST reflects the combined logic.
3. Implement sample JSON data and test the evaluate_rule API for various scenarios.

## Bonus Features

Consider implementing these advanced features:

1. Error Handling: Implement error handling for invalid rule strings or data formats (e.g., missing operators, invalid comparisons).
2. Attribute Validation: Ensure attributes are part of a catalog.
3. Rule Modification: Enable modification of existing rules.
4. Custom Functions: Extend the system to support user-defined functions within the rule language for advanced conditions.


