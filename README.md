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

