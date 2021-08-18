# CRUD REST with Spring Boot and JPA
[![Donate](https://img.shields.io/badge/Donate-PayPal-green.svg)](https://paypal.me/yonhbu?locale.x=es_XC)

In this repository we work with Spring Boot and with Spring Data. Using these two Spring modules, we will create a CRUD REST SERVICE using JPA and a database engine in H2 memory. Good programming practices are applied such as some Solid principles (Immutability and Clean Code), Design Patterns (Builder, Mvc), Unit Testing and Lombok functions.


**Technologies**

- Java - Spring Boot Framework
- Postman - Testing API
- H2 - Database
- JDK - Java 8
- Project Construction - Maven
- Core - Spring MVC
- Library - Spring Boot Actuator


**Starter Project Dependencies**

1. spring-boot-starter-data-jpa
2. spring-boot-starter-web
3. jpa
4. junit

**Practical Exercise Employee**

Create a project in SpringBoot with an h2 database (in memory).
The project must have the following entities: Candidate, Employee, Position

![image](https://user-images.githubusercontent.com/32151636/129928413-c0a1212f-55a8-46ef-8e0d-865b30998be1.png)
![image](https://user-images.githubusercontent.com/32151636/129928541-a1b5e811-cdeb-4804-b4e5-5feb56464b37.png)

the service must expose a Rest API that allows to do the following operations:
● Create Employee
● Update Employee
● Delete Employee
● List all employees (This Endpoint must allow filtering by position or name)
these parameters are optional, if you don't send any of these you must bring all
the employees.
● Return a list with all the positions, and within the positions all the employees
ordered by salary from highest to lowest.

**Respuesta esperada:**
```
[
{
"id": 1,
"name": "dev",
"employees": [
{
"id": 1,
"salary": 2000,
"person": {
"name": "Camilo",
"lastNam2": "ruiz",
"address": "cra",
"cellphone": "124",
"cityName": "Medellin"
}
},
{
"id": 2,
"salary": 1000,
"person": {
"name": "Andres",
"lastNam2": "escobar",
"address": "cra",
"cellphone": "1244",
"cityName": "Envigado"
}
}
]
},
{
"id": 2,
"name": "qa",
"employees": [
{
"id": 4,
"salary": 1500,
"person": {
"name": "luis",
"lastNam2": "perez",
"address": "cra",
"cellphone": "124",
"cityName": "Medellin"
}
},
{
"id": 5,
"salary": 1000,
"person": {
"name": "pedro",
"lastNam2": "castro",
"address": "cra",
"cellphone": "1244",
"cityName": "Envigado"
}
}
]
}
]
```


