# Klik Store API

Backend Developer Technical Assignment\
Author: Agnes Abigael Hutauruk

------------------------------------------------------------------------

# Overview

Klik Store API adalah RESTful backend service yang dibangun menggunakan
Spring Boot 3 dengan implementasi:

-   Layered Architecture (Controller → Repository → Entity)
-   JWT Authentication
-   Soft Delete mechanism
-   Whitelist Store logic
-   Pagination
-   DTO-based response mapping
-   PostgreSQL integration

------------------------------------------------------------------------

# Architecture

Client (Postman / Browser) ↓ Spring Security (JWT Filter) ↓ Controller
Layer ↓ Repository Layer (JPA) ↓ PostgreSQL Database

------------------------------------------------------------------------

# Tech Stack

-   Java 17
-   Spring Boot 3
-   Spring Data JPA
-   Spring Security (JWT)
-   PostgreSQL
-   Maven
-   Lombok

------------------------------------------------------------------------

# Features

## Province, Branch, Store Management

-   Province memiliki banyak Branch (1:N)
-   Branch memiliki banyak Store (1:N)
-   Store dapat dimasukkan ke dalam Whitelist

## Soft Delete

Semua entity menggunakan flag `isDeleted = true/false`. Data tidak
benar-benar dihapus dari database.

## Whitelist Store Logic

-   Store whitelist tetap ditampilkan
-   Store non-whitelist mengikuti filtering province
-   Duplicate store dihilangkan menggunakan Set logic

## Pagination

Endpoint `/stores` mendukung pagination: - page (default: 0) - size
(default: 10)

------------------------------------------------------------------------

# Authentication

## Login

POST /auth/login

Request: { "username": "admin", "password": "admin" }

Response: { "token": "jwt_token_here" }

Gunakan token pada header:

Authorization: Bearer `<token>`{=html}

------------------------------------------------------------------------

# API Endpoint

## GET /stores?provinceName=Bandung

Header: Authorization: Bearer `<token>`{=html}

Query Params: - provinceName (required) - page (optional) - size
(optional)

------------------------------------------------------------------------

# Database

Menggunakan PostgreSQL.

Konfigurasi di application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/klik_store
spring.datasource.username=postgres
spring.datasource.password=yourpassword

------------------------------------------------------------------------

# Run Application

Windows: mvnw.cmd clean install mvnw.cmd spring-boot:run

Access: http://localhost:8080/login.html

------------------------------------------------------------------------

# Entity Relationship

Province (1) → (N) Branch\
Branch (1) → (N) Store\
Store (1) → (1) WhitelistStore


<img width="557" height="517" alt="ERD drawio" src="https://github.com/user-attachments/assets/2279bc7a-e1e1-4899-bb88-e0c7feb05c6f" />

------------------------------------------------------------------------

Project ini dibuat sebagai bagian dari Backend Developer Technical
Assignment.
