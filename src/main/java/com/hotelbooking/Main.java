package com.hotelbooking;


/**
 * Main class to demonstrate the hotel booking system.
 */

public class Main {

    public static void main(String[] args) {
        HotelChain chain = new HotelChain("Pearl Chain");

        // Create hotel and rooms
        Hotel hotel = new Hotel("Pearl Inn", 1);
        Room r1 = new Room(101, RoomType.DOUBLE);
        Room r2 = new Room(102, RoomType.SUITE);
        hotel.addRoom(r1);
        hotel.addRoom(r2);

        // Create customer
        Customer customer = Customer.create("Ali", "Lahore");

        // Book a room
        java.time.LocalDate from = java.time.LocalDate.now().plusDays(1);
        java.time.LocalDate to = from.plusDays(3);
        Booking booking = hotel.bookRoom(customer, r1, from, to);
        booking.confirm();

        System.out.println("Booking created: " + booking.getRoom().getNumber() + " for " + booking.getCustomer().getName());

        // Cancel booking
        booking.cancel();

        System.out.println("Booking status after cancel: " + booking.getStatus());
    }
}
