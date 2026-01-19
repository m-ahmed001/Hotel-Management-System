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

## Project Structure

```
src/
├── main/java/com/hotelbooking/
│   ├── Booking.java
│   ├── BookingStatus.java
│   ├── Customer.java
│   ├── Hotel.java
│   ├── Main.java
│   ├── Room.java
│   └── RoomType.java
└── test/java/com/hotelbooking/
    ├── BookingTest.java
    ├── CustomerTest.java
    ├── HotelTest.java
    └── RoomTest.java
```

## Design Principles Applied

### Object-Oriented Design
- **Encapsulation**: Private fields with public getters/setters where appropriate
- **Inheritance**: Not applicable in this simple model
- **Polymorphism**: Not applicable in this simple model
- **Abstraction**: Clear separation of concerns between classes

### Clean Code Practices
- Meaningful class, method, and variable names
- Small, focused methods
- Single Responsibility Principle
- DRY (Don't Repeat Yourself)

### Defensive Programming
- Input validation in constructors and methods
- Null checks with descriptive error messages
- Exception handling with appropriate exception types

### Testing Strategy
- Unit tests for all domain classes
- Parameterized tests for boundary conditions
- AAA (Arrange-Act-Assert) pattern
- Tests for normal cases, edge cases, and invalid inputs
- High test coverage

## UML Diagram

The system is based on the following UML class diagram:

```
+----------------+       +-----------------+
|     Hotel      |       |     Customer    |
+----------------+       +-----------------+
| - name: String |       | - name: String  |
| - location: String|    | - email: String |
| - rooms: List<Room>|   | - phone: String |
| - bookings: List<Booking>| - bookings: List<Booking> |
+----------------+       +-----------------+
| + addRoom()    |       | + addBooking()  |
| + removeRoom() |       +-----------------+
| + getAvailableRooms()|
| + bookRoom()   |
+----------------+

          |                    |
          |                    |
          v                    v

+----------------+       +-----------------+
|     Room       |       |    Booking      |
+----------------+       +-----------------+
| - roomNumber: int|     | - customer: Customer|
| - type: RoomType|      | - room: Room    |
| - price: double |      | - checkInDate: LocalDate|
| - isAvailable: boolean| | - checkOutDate: LocalDate|
+----------------+       | - status: BookingStatus|
| + getRoomNumber()|     +-----------------+
| + getType()     |     | + confirm()     |
| + getPrice()    |     | + cancel()      |
| + isAvailable() |     +-----------------+
| + setAvailable()|
+----------------+

+----------------+
|  RoomType      |
+----------------+
| SINGLE         |
| DOUBLE         |
| SUITE          |
+----------------+

+----------------+
| BookingStatus  |
+----------------+
| PENDING        |
| CONFIRMED      |
| CANCELLED      |
+----------------+
```

Relationships:
- Hotel aggregates Room (1..*)
- Hotel aggregates Booking (1..*)
- Customer aggregates Booking (1..*)
- Booking associates with Customer (1)
- Booking associates with Room (1)
