# GridWeaver Backend

## Overview
GridWeaver Backend is a Spring Boot REST API for a real-time IoT Microgrid Monitoring System.

## Tech Stack
- Java 21+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Git & GitHub

## Features
- User CRUD APIs
- MySQL Database Integration
- RESTful API Development
- Spring Data JPA

## API Endpoints

### Create User
POST /users

Example JSON:
{
  "username": "priyanshu",
  "email": "priyanshu@gmail.com"
}

### Get All Users
GET /users

## Run the Project

1. Clone the repository
2. Configure MySQL
3. Update `application.properties`
4. Run the application
5. Open:

http://localhost:8080/users
