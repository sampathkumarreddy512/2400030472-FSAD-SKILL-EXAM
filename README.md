# Booking Management System

A Spring Boot application for managing bookings with CRUD operations, built for the FSAD Skill Exam.

## Overview

This is a complete booking management system implemented using Spring Boot, Spring Data JPA, and MySQL. It provides REST API endpoints for creating, reading, updating, and deleting booking records.

## Project Structure

```
src/main/
├── java/com/klef/fsad/exam/
│   ├── BookingApplication.java          (Main Spring Boot application class)
│   ├── controller/
│   │   └── BookingController.java       (REST API endpoints)
│   ├── service/
│   │   └── BookingService.java          (Business logic layer)
│   ├── repo/
│   │   └── BookingRepository.java       (Data access layer)
│   └── entity/
│       └── Booking.java                 (JPA entity)
└── resources/
    └── application.properties           (Database configuration)
```

## Technology Stack

- **Framework**: Spring Boot 2.7.0
- **Database**: MySQL 8.0.33
- **ORM**: Spring Data JPA with Hibernate
- **Language**: Java 1.8
- **Build Tool**: Maven

## Features

### Booking Entity
The Booking entity has the following attributes:
- `bookingId` - Unique identifier (auto-generated)
- `name` - Booking name
- `date` - Booking date
- `status` - Booking status
- `details` - Additional booking details

### REST API Endpoints

#### 1. Create Booking
- **POST** `/api/bookings/add`
- **Request Body**: Booking object (JSON)
- **Response**: Created Booking object with HTTP 201 CREATED

#### 2. Get All Bookings
- **GET** `/api/bookings/all`
- **Response**: List of all bookings with HTTP 200 OK

#### 3. Get Booking by ID
- **GET** `/api/bookings/{id}`
- **Path Variable**: `id` - Booking ID
- **Response**: Booking object with HTTP 200 OK, or HTTP 404 NOT_FOUND if not exists

#### 4. Update Booking
- **PUT** `/api/bookings/{id}`
- **Path Variable**: `id` - Booking ID
- **Request Body**: Updated Booking object (JSON)
- **Response**: Updated Booking object with HTTP 200 OK

#### 5. Delete Booking
- **DELETE** `/api/bookings/{id}`
- **Path Variable**: `id` - Booking ID
- **Response**: Success message with HTTP 200 OK

## Setup and Installation

### Prerequisites
- JDK 1.8 or higher
- MySQL Server 8.0 or higher
- Maven 3.6 or higher

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/sampathkumarreddy512/2400030472-FSAD-SKILL-EXAM.git
   cd 2400030472-FSAD-SKILL-EXAM
   ```

2. **Create MySQL Database**
   ```sql
   CREATE DATABASE IF NOT EXISTS fsadexam;
   ```

3. **Configure Database Connection**
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/fsadexam
   spring.datasource.username=root
   spring.datasource.password=<your_password>
   ```

4. **Build the Project**
   ```bash
   mvn clean install
   ```

5. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```
   The application will start on `http://localhost:8080`

## API Usage Examples

### Create a Booking
```bash
curl -X POST http://localhost:8080/api/bookings/add \
  -H "Content-Type: application/json" \
  -d '{"name":"Hotel Room","date":"2024-03-20","status":"Confirmed","details":"Deluxe Room"}'
```

### Get All Bookings
```bash
curl http://localhost:8080/api/bookings/all
```

### Get Booking by ID
```bash
curl http://localhost:8080/api/bookings/1
```

### Update Booking
```bash
curl -X PUT http://localhost:8080/api/bookings/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Hotel Room","date":"2024-03-25","status":"Cancelled","details":"Deluxe Room"}'
```

### Delete Booking
```bash
curl -X DELETE http://localhost:8080/api/bookings/1
```

## Project Status

✅ **COMPLETE** - All required components have been implemented:
- Entity Layer (Booking)
- Repository Layer (BookingRepository)
- Service Layer (BookingService)
- Controller Layer (BookingController)
- Configuration (application.properties)
- Build Configuration (pom.xml)

## Files Included

- `pom.xml` - Maven project configuration with all dependencies
- `src/main/java/com/klef/fsad/exam/entity/Booking.java` - JPA Entity
- `src/main/java/com/klef/fsad/exam/repo/BookingRepository.java` - Data Access Interface
- `src/main/java/com/klef/fsad/exam/service/BookingService.java` - Business Logic
- `src/main/java/com/klef/fsad/exam/controller/BookingController.java` - REST API Controller
- `src/main/java/com/klef/fsad/exam/BookingApplication.java` - Spring Boot Main Class
- `src/main/resources/application.properties` - Application Configuration
- `README.md` - This file

## Author

Sampath Kumar Reddy
Student ID: 2400030472

## License

This project is for educational purposes as part of the FSAD Skill Exam.
