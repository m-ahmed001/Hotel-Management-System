package com.hotelbooking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void shouldCreateValidRoom() {
        // Arrange & Act
        Room room = new Room(101);

        // Assert
        assertNotNull(room);
        assertFalse(room.isOccupied());
    }

    @Test
    void shouldCreateGuestFromRoom() {
        // Arrange
        Room room = new Room(101);

        // Act
        Guest guest = room.createGuest("Ali", "Lahore");

        // Assert
        assertNotNull(guest);
    }

    @Test
    void shouldRejectInvalidRoomNumber() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Room(0));
    }
}
