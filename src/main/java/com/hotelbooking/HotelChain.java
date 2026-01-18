package com.hotelbooking;

public class HotelChain {

    private final String name;

    public HotelChain(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("HotelChain name cannot be empty");
        }
        this.name = name;
    }
public String getName() {
    return name;
}

    public Reservation makeReservation(Hotel hotel) {
        validateHotel(hotel);
        return hotel.createReservation();
    }

    public void cancelReservation(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation cannot be null");
        }
    }

    public void checkInGuest(Guest guest) {
        if (guest == null) {
            throw new IllegalArgumentException("Guest cannot be null");
        }
    }

    public void checkOutGuest(Guest guest) {
        if (guest == null) {
            throw new IllegalArgumentException("Guest cannot be null");
        }
    }

    public ReserverPayer createReserverPayer(String id, String card) {
        return ReserverPayer.create(id, card);
    }

    private void validateHotel(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel cannot be null");
        }
    }
}

