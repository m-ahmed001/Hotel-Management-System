package com.hotelbooking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotelChainTest {

    @Test
    void shouldCreateReservationViaHotel() {
        // Arrange
        HotelChain chain = new HotelChain("Pearl Chain");
        Hotel hotel = new Hotel("Pearl Inn", 1);

        // Act
        Reservation reservation = chain.makeReservation(hotel);

        // Assert
        assertNotNull(reservation);
    }

    @Test
    void shouldRejectNullHotel() {
        // Arrange
        HotelChain chain = new HotelChain("Pearl Chain");

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> chain.makeReservation(null));
    }

    @Test
    void shouldCreateReserverPayer() {
        // Arrange
        HotelChain chain = new HotelChain("Pearl Chain");

        // Act
        ReserverPayer payer = chain.createReserverPayer("ID1", "CARD");

        // Assert
        assertNotNull(payer);
    }
}

