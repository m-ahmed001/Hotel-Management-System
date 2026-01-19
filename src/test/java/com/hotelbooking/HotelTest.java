package com.hotelbooking;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void shouldCreateValidHotel() {
        // Arrange & Act
        Hotel hotel = new Hotel("Pearl Inn", 1);

        // Assert
        assertNotNull(hotel);
    }

    @Test
    void shouldCreateReservation() {
        // Arrange
        Hotel hotel = new Hotel("Pearl Inn", 1);

        // Act
        Reservation reservation = hotel.createReservation();

        // Assert
        assertNotNull(reservation);
    }

    @Test
    void shouldRejectInvalidHotelNumber() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Hotel("Pearl Inn", 0));
    }

    @Test
    void addRoomsAndFindAvailability() {
        // Arrange
        Hotel hotel = new Hotel("Test Hotel", 1);
        Room r1 = new Room(101, RoomType.SINGLE);
        Room r2 = new Room(102, RoomType.DOUBLE);
        hotel.addRoom(r1);
        hotel.addRoom(r2);

        LocalDate from = LocalDate.now().plusDays(1);
        LocalDate to = from.plusDays(2);

        // Act
        List<Room> available = hotel.getAvailableRooms(from, to);

        // Assert
        assertEquals(2, available.size());
    }

    @Test
    void bookingWorkflow() {
        // Arrange
        Hotel hotel = new Hotel("Test Hotel", 1);
        Room r = new Room(201, RoomType.SUITE);
        hotel.addRoom(r);
        Customer c = Customer.create("Bob", "Addr");
        LocalDate from = LocalDate.now().plusDays(1);
        LocalDate to = from.plusDays(1);

        // Act
        Booking b = hotel.bookRoom(c, r, from, to);

        // Assert pending
        assertEquals(BookingStatus.PENDING, b.getStatus());

        // Confirm and ensure room reserved
        b.confirm();
        assertEquals(BookingStatus.CONFIRMED, b.getStatus());
        assertTrue(r.isOccupied());
    }
}
