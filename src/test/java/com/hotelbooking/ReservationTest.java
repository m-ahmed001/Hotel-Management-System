package com.hotelbooking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void shouldCreateReservationWithDate() {
        // Arrange & Act
        Reservation reservation = Reservation.create();

        // Assert
        assertNotNull(reservation);
    }
}

