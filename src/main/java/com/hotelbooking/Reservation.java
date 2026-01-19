package com.hotelbooking;

import java.time.LocalDate;

public class Reservation {

    private final LocalDate reservationDate;

    private Reservation() {
        this.reservationDate = LocalDate.now();
    }

    public LocalDate getReservationDate() {
        return reservationDate;
}

    public static Reservation create() {
        return new Reservation();
    }
}

