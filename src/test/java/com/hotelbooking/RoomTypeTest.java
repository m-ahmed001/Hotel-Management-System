package com.hotelbooking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class RoomTypeTest {

    @ParameterizedTest
    @ValueSource(doubles = {1000, 2500, 9999})
    void shouldAcceptValidCost(double cost) {
        // Arrange & Act
        RoomType type = new RoomType("DOUBLE", cost);

        // Assert
        assertNotNull(type);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -500})
    void shouldRejectInvalidCost(double cost) {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> new RoomType("DOUBLE", cost));
    }
}

