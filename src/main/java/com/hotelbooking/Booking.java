package com.hotelbooking;

import java.time.LocalDate;
import java.util.Objects;

public class Booking {

    private final Customer customer;
    private final Room room;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private BookingStatus status;

    public Booking(Customer customer, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.customer = Objects.requireNonNull(customer, "Customer required");
        this.room = Objects.requireNonNull(room, "Room required");
        this.checkIn = Objects.requireNonNull(checkIn, "Check-in date required");
        this.checkOut = Objects.requireNonNull(checkOut, "Check-out date required");

        if (checkOut.isBefore(checkIn)) {
            throw new IllegalArgumentException("Check-out cannot be before check-in");
        }

        this.status = BookingStatus.PENDING;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void confirm() {
        if (status == BookingStatus.CANCELLED) throw new IllegalStateException("Cannot confirm cancelled booking");
        this.status = BookingStatus.CONFIRMED;
        room.reserve();
    }

    public void cancel() {
        if (status == BookingStatus.CANCELLED) return;
        this.status = BookingStatus.CANCELLED;
        room.free();
    }
}
