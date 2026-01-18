package com.hotelbooking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReserverPayerTest {

    @Test
    void shouldCreateValidReserverPayer() {
        // Arrange & Act
        ReserverPayer rp = ReserverPayer.create("ID1", "CARD");

        // Assert
        assertNotNull(rp);
    }

    @Test
    void shouldRejectEmptyId() {
        assertThrows(IllegalArgumentException.class,
                () -> ReserverPayer.create("", "CARD"));
    }
}
