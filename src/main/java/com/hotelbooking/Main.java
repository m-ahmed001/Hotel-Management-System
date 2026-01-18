package com.hotelbooking;


/**
 * Main class to demonstrate the hotel booking system.
 */

public class Main {

    public static void main(String[] args) {

        HotelChain chain = new HotelChain("Pearl Chain");
    //    Hotel hotel = new Hotel("Pearl Inn", 1);

      //  ReserverPayer payer = chain.createReserverPayer("ID1", "1234-5678");
        //Reservation reservation = chain.makeReservation(hotel);

        Room room = new Room(101);
        Guest guest = room.createGuest("Ali", "Lahore");

        chain.checkInGuest(guest);
        chain.checkOutGuest(guest);

        System.out.println("System executed successfully");
    }
}
