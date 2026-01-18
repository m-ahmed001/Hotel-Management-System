package com.hotelbooking;


public class ReserverPayer {

    private final String id;
    private final String creditCardDetails;

    private ReserverPayer(String id, String creditCardDetails) {
        this.id = validate(id, "ID");
        this.creditCardDetails = validate(creditCardDetails, "Credit Card");
    }

    public static ReserverPayer create(String id, String creditCardDetails) {
        return new ReserverPayer(id, creditCardDetails);
    }

    private static String validate(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " cannot be empty");
        }
        return value;
    }

    public String getId() {
        return id;
    }

    public String getCreditCardDetails() {
        return creditCardDetails;
    }
}
