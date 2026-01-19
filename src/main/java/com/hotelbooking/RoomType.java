package com.hotelbooking;

/**
 * Room types as an enum with default costs.
 */
public enum RoomType {
    SINGLE(100.0),
    DOUBLE(150.0),
    SUITE(300.0);

    private final double cost;

    RoomType(double cost) {
        if (cost <= 0) throw new IllegalArgumentException("Cost must be positive");
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
