# Hotel Booking System

A Java-based hotel booking system implemented following object-oriented design principles, clean code practices, defensive programming techniques, and industry-standard testing strategies.

## Project Overview

This system models a hotel booking application with the following main components:
- **Hotel**: Manages rooms and bookings
- **Room**: Represents individual hotel rooms with type, price, and availability
- **Customer**: Represents customers who can make bookings
- **Booking**: Represents reservations with check-in/check-out dates and status

## Features

- Room management (add/remove rooms)
- Customer registration
- Room availability checking
- Booking creation, confirmation, and cancellation
- Date-based availability validation

## Build and Run Instructions

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Building the Project
```bash
mvn clean compile
```

### Running Tests
```bash
mvn test
```

### Running the Application
```bash
mvn exec:java -Dexec.mainClass="com.hotelbooking.Main"
```
# Hotel Booking System

This project implements a small hotel booking domain following the provided UML and assignment requirements: clean code, defensive programming, and thorough unit tests.

## Overview

Main domain types:
- `Hotel` — manages rooms and bookings
- `Room` — room number, type and availability
- `RoomType` — enum (`SINGLE`, `DOUBLE`, `SUITE`) with default costs
- `Customer` — represents a customer
- `Booking` — reservation with check-in/check-out and status
- `BookingStatus` — enum (`PENDING`, `CONFIRMED`, `CANCELLED`)

## Build & Run

Prerequisites: Java 11+, Maven 3.6+

Build:
```bash
mvn clean compile
```

Run tests:
```bash
mvn test
```

Run main demo:
```bash
mvn exec:java -Dexec.mainClass="com.hotelbooking.Main"
```

## Tests

Unit tests are located under `src/test/java/com/hotelbooking`. Tests use JUnit 5 and include parameterized tests and AAA style assertions. They cover normal flows, boundary conditions and invalid inputs.

## Notes for Submission

- Ensure at least 5 meaningful commits on different dates (commit granularity and dates should be created from your machine / GitHub UI).
- Include screenshots of test results and repository history for the assignment document.

If you want, I can:
- run the test suite (already executed and passing),
- help prepare the screenshots and README additions for the submission,
- or create a sample commit history branch to illustrate commit content.