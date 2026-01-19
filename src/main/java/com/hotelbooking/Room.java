package com.hotelbooking;



/**
 * Represents a room in the hotel.
 */

public class Room {

    private final int number;
    private boolean occupied;
    private final RoomType type;

    public Room(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Room number invalid");
        }
        this.number = number;
        this.occupied = false;
        this.type = RoomType.SINGLE;
    }

    
    public Room(int number, RoomType type) {
        if (number <= 0) throw new IllegalArgumentException("Room number invalid");
        if (type == null) throw new IllegalArgumentException("RoomType required");
        this.number = number;
        this.type = type;
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

    public boolean isAvailable() {
        return !occupied;
    }

    public RoomType getType() {
        return type;
    }

    public void reserve() {
        if (occupied) throw new IllegalStateException("Room already reserved");
        this.occupied = true;
    }

    public void free() {
        this.occupied = false;
    }
}
