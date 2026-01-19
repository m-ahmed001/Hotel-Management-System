package com.hotelbooking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Hotel {

    private final String name;
    private final int number;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();

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

    public void addRoom(Room room) {
        if (room == null) throw new IllegalArgumentException("Room cannot be null");
        rooms.add(room);
    }

    public boolean removeRoom(Room room) {
        return rooms.remove(room);
    }

    public List<Room> getAvailableRooms(LocalDate from, LocalDate to) {
        if (from == null || to == null) throw new IllegalArgumentException("Dates required");
        if (to.isBefore(from)) throw new IllegalArgumentException("Invalid date range");

        List<Room> available = new ArrayList<>();
        for (Room r : rooms) {
            boolean booked = bookings.stream()
                    .filter(b -> b.getRoom().getNumber() == r.getNumber())
                    .anyMatch(b -> overlaps(b.getCheckIn(), b.getCheckOut(), from, to) && b.getStatus() != BookingStatus.CANCELLED);
            if (!booked && r.isAvailable()) available.add(r);
        }
        return Collections.unmodifiableList(available);
    }

    public Booking bookRoom(Customer customer, Room room, LocalDate from, LocalDate to) {
        Objects.requireNonNull(customer);
        Objects.requireNonNull(room);
        if (from == null || to == null) throw new IllegalArgumentException("Dates required");
        if (to.isBefore(from)) throw new IllegalArgumentException("Invalid date range");

        // ensure room belongs to hotel
        if (!rooms.contains(room)) throw new IllegalArgumentException("Room not part of hotel");

        // ensure no overlapping booking exists
        boolean overlap = bookings.stream()
                .filter(b -> b.getRoom().getNumber() == room.getNumber())
                .anyMatch(b -> overlaps(b.getCheckIn(), b.getCheckOut(), from, to) && b.getStatus() != BookingStatus.CANCELLED);

        if (overlap) throw new IllegalStateException("Room already booked for given dates");

        Booking booking = new Booking(customer, room, from, to);
        bookings.add(booking);
        return booking;
    }

    private boolean overlaps(LocalDate s1, LocalDate e1, LocalDate s2, LocalDate e2) {
        return !e1.isBefore(s2) && !e2.isBefore(s1);
    }

    public List<Booking> getBookings() {
        return Collections.unmodifiableList(bookings);
    }

    // Backwards compatible reservation creation used by older tests/HotelChain
    public Reservation createReservation() {
        return Reservation.create();
    }
}
