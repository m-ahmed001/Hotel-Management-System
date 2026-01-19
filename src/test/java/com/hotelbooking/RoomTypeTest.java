package com.hotelbooking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.*;

class RoomTypeTest {

    @ParameterizedTest
    @EnumSource(RoomType.class)
    void enumHasPositiveCost(RoomType type) {
        // Arrange & Act & Assert
        assertTrue(type.getCost() > 0);
    }
}

