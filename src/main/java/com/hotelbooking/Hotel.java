package com.hotelbooking;

public class Hotel {

    private final String name;
    private final int number;

    public Hotel(String name, int number) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Hotel name invalid");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("Hotel number must be positive");
        }
        this.name = name;
        this.number = number;
    }
public String getName() {
    return name;
}

public int getNumber() {
    return number;
}

    public Reservation createReservation() {
        return Reservation.create();
    }

    public boolean available() {
        return true;
    }
}
