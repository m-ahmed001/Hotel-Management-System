package com.hotelbooking;



/**
 * Represents a room in the hotel.
 */

public class Room {

    private final int number;
    private boolean occupied;

    public Room(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Room number invalid");
        }
        this.number = number;
        this.occupied = false;
    }
    
public int getNumber() {
    return number;
}
    public Guest createGuest(String name, String address) {
        return Guest.create(name, address);
    }

    public boolean isOccupied() {
        return occupied;
    }
}
