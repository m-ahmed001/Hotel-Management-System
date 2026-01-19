package com.hotelbooking;

public class Customer {

    private final String name;
    private final String address;

    private Customer(String name, String address) {
        this.name = validate(name, "Name");
        this.address = validate(address, "Address");
    }

    public static Customer create(String name, String address) {
        return new Customer(name, address);
    }

    private static String validate(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " cannot be empty");
        }
        return value;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
