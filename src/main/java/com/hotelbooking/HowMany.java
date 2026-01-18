package com.hotelbooking;

public class HowMany {

    private final int number;

    public HowMany(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

