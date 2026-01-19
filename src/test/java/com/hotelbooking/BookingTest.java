package com.hotelbooking;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void createAndConfirmBooking() {
        // Arrange
        Customer c = Customer.create("Ali", "Lahore");
        Room r = new Room(101, RoomType.SINGLE);
        LocalDate from = LocalDate.now().plusDays(1);
        LocalDate to = from.plusDays(2);

        // Act
        Booking booking = new Booking(c, r, from, to);

        // Assert
        assertNotNull(booking);
        assertEquals(BookingStatus.PENDING, booking.getStatus());

        // Act confirm
        booking.confirm();

        // Assert confirmed and room reserved
        assertEquals(BookingStatus.CONFIRMED, booking.getStatus());
        assertTrue(r.isOccupied());
    }

    @Test
    void rejectInvalidDates() {
        Customer c = Customer.create("Ali", "Lahore");
        Room r = new Room(101, RoomType.SINGLE);
        LocalDate from = LocalDate.now().plusDays(5);
        LocalDate to = from.minusDays(1);

        assertThrows(IllegalArgumentException.class, () -> new Booking(c, r, from, to));
    }
}
