package com.hotelbooking;

/**
 * Enum representing the type of room.
 */


public class RoomType {

    private final String kind;
    private final double cost;

    public RoomType(String kind, double cost) {
        if (kind == null || kind.isBlank()) {
            throw new IllegalArgumentException("Room kind required");
        }
        if (cost <= 0) {
            throw new IllegalArgumentException("Cost must be positive");
        }

        this.kind = kind;
        this.cost = cost;
    }
     public String getKind() {
    return kind;
}

    public double getCost() {
        return cost;
    }
}
