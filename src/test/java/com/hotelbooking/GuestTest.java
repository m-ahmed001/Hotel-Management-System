package com.hotelbooking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    void shouldCreateValidGuest() {
        // Arrange & Act
        Guest guest = Guest.create("Ali", "Lahore");

        // Assert
        assertNotNull(guest);
        assertEquals("Ali", guest.getName());
    }

    @Test
    void shouldRejectEmptyName() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> Guest.create("", "Lahore"));
    }

    @Test
    void shouldRejectNullAddress() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> Guest.create("Ali", null));
    }
}
