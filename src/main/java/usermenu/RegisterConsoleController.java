package usermenu;

import guest.Guest;
import hotelrooms.HotelService;
import hotelrooms.HotelServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterConsoleController {

    private final String MESSAGE_REGISTER = "Please choose a room to reserve or 0 to go back to the main menu";

    private final String MESSAGE_UNREGISTER = "Please choose a room to release or 0 to go back to the main menu";

    private HotelService hotelService;

    public RegisterConsoleController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    void register() {
        System.out.println(MESSAGE_REGISTER);
        try {
            Integer roomNr = getRoomNr();
            if (roomNr == null) return;
            hotelService.validateRoomNumber(roomNr);
            List<Guest> guests = prepareGuests();
            hotelService.register(roomNr, guests);
            System.out.println("Room " + roomNr + " reserved");
        } catch (HotelServiceException e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    private Integer getRoomNr() {
        int userInput = ConsoleInput.getUserInput();
        if (userInput == 0) {
            System.out.println("Returning to main menu");
            return null;
        }
        return userInput;
    }

    private List<Guest> prepareGuests() {
        List<Guest> guests = new ArrayList<>();
        boolean addNext;
        do {
            Guest guest = prepareGuest();
            guests.add(guest);
            System.out.println("Do you want to invite second guest?");
            addNext = getYesOrNoInput();
        } while (addNext);
      RegisterConsoleController.method();
        return guests;
    }

    public static void method() {

    }

    private boolean getYesOrNoInput() {
        String line = new Scanner(System.in).nextLine();
        if ( line.equalsIgnoreCase("yes") || line.equalsIgnoreCase("y")) {
            return true;
        } else if (line.equalsIgnoreCase("no") || line.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Say yes or no");
            return getYesOrNoInput();
        }
    }

    private Guest prepareGuest() {
        //form
        //todo not yet implemented

        return new Guest(null,"","");
    }

     void unregister() {
        System.out.println(MESSAGE_REGISTER);
        try {
            Integer roomNumber = getRoomNr();
            if (roomNumber == null) return;
            hotelService.unregister(roomNumber);
            System.out.println("Room " + roomNumber + " is unregistered");
        } catch (HotelServiceException e) {
            System.out.println(e.getMessage());
            unregister();
        }
    }

}
