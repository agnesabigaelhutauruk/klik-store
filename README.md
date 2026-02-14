# Klik Store API

Backend Developer Technical Assignment

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Security (JWT)
- PostgreSQL
- Maven

---

## Features

- Province, Branch, Store management
- Soft Delete (isDeleted flag)
- Whitelist Store logic
- Pagination
- DTO-based response
- JWT Authentication
- Simple login demo page

---

## Authentication

Login endpoint:

POST /auth/login

Body:
{
"username": "admin",
"password": "admin"
}

Response:
JWT token

Use Bearer Token in Authorization header.

---

## Example API

Get Stores by Province:

GET /stores?provinceName=Bandung

Header:
Authorization: Bearer <token>

---

## Database

Using PostgreSQL.

Configure in application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/klik_store
spring.datasource.username=postgres
spring.datasource.password=yourpassword

---

## Run Application

mvn spring-boot:run

Access:
http://localhost:8080/login.html