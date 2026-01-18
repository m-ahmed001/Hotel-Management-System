package com.hotelbooking;



public class Guest {

    private final String name;
    private final String address;

    private Guest(String name, String addressDetails) {
        this.name = validate(name, "Name");
        this.address = validate(addressDetails, "Address");
    }

    public static Guest create(String name, String addressDetails) {
        return new Guest(name, addressDetails);
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

