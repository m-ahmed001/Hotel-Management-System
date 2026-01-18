package com.hotelbooking;

import org.junit.jupiter.api.Test;
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
}
