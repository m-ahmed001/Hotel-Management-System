package com.hotelbooking;


/**
 * Main class to demonstrate the hotel booking system.
 */

public class Main {

    public static void main(String[] args) {

        HotelChain chain = createHotelChain();
        Hotel hotel = createHotel();

        ReserverPayer payer = createReserverPayer(chain);
        Reservation reservation = makeReservation(chain, hotel);

        Room room = createRoom();
        Guest guest = createGuest(room);

        checkInAndOut(chain, guest);

        printSummary(chain, hotel, payer, reservation, room, guest);

        System.out.println("\nSystem executed successfully ✔");
    }

    // ---------- Helper Methods ----------

    private static HotelChain createHotelChain() {
        HotelChain chain = new HotelChain("Pearl Chain");
        System.out.println("Hotel Chain created: " + chain.getName());
        return chain;
    }

    private static Hotel createHotel() {
        Hotel hotel = new Hotel("Pearl Inn", 1);
        System.out.println("Hotel created: " + hotel.getName()
                + " | Hotel Number: " + hotel.getNumber());
        return hotel;
    }

    private static ReserverPayer createReserverPayer(HotelChain chain) {
        ReserverPayer payer = chain.createReserverPayer("ID1", "1234-5678");
        System.out.println("ReserverPayer created with ID: " + payer.getId());
        return payer;
    }

    private static Reservation makeReservation(HotelChain chain, Hotel hotel) {
        Reservation reservation = chain.makeReservation(hotel);
        System.out.println("Reservation created on: "
                + reservation.getReservationDate());
        return reservation;
    }

    private static Room createRoom() {
        Room room = new Room(101);
        System.out.println("Room created with number: " + room.getNumber());
        return room;
    }

    private static Guest createGuest(Room room) {
        Guest guest = room.createGuest("Ali", "Lahore");
        System.out.println("Guest created: " + guest.getName());
        return guest;
    }

    private static void checkInAndOut(HotelChain chain, Guest guest) {
        chain.checkInGuest(guest);
        System.out.println("Guest checked in: " + guest.getName());

        chain.checkOutGuest(guest);
        System.out.println("Guest checked out: " + guest.getName());
    }

    private static void printSummary(
            HotelChain chain,
            Hotel hotel,
            ReserverPayer payer,
            Reservation reservation,
            Room room,
            Guest guest) {

        System.out.println("\n------ SYSTEM SUMMARY ------");
        System.out.println("Hotel Chain : " + chain.getName());
        System.out.println("Hotel       : " + hotel.getName());
        System.out.println("Hotel No    : " + hotel.getNumber());
        System.out.println("Room No     : " + room.getNumber());
        System.out.println("Guest Name  : " + guest.getName());
        System.out.println("Payer ID    : " + payer.getId());
        System.out.println("Reservation : " + reservation.getReservationDate());
        System.out.println("----------------------------");
    }
}
