package com.hotelbooking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class HowManyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    void validNumbersAccepted(int value) {
        assertDoesNotThrow(() -> new HowMany(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5})
    void negativeNumbersRejected(int value) {
        assertThrows(IllegalArgumentException.class,
                () -> new HowMany(value));
    }
}

