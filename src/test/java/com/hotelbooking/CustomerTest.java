package com.hotelbooking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldCreateValidCustomer() {
        // Arrange & Act
        Customer c = Customer.create("Ali", "Lahore");

        // Assert
        assertNotNull(c);
        assertEquals("Ali", c.getName());
    }

    @Test
    void shouldRejectEmptyName() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Customer.create("", "Addr"));
    }
}
