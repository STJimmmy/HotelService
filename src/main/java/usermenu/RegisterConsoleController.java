package usermenu;

import guest.Guest;
import hotelrooms.HotelService;
import hotelrooms.HotelServiceException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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

            List<Guest> guests = prepareGuests(roomNr);
            if (guests.isEmpty()) {
                return;
            }

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

    private List<Guest> prepareGuests(int roomNumber) { // if the 2nd customers input is cancelled, the program should
        // check with the user whether he/she wants to register only one customer; if yes - register, if no - ask the user to input additional guests data again
        List<Guest> guests = new ArrayList<>();

        Guest guest;
        Guest additionalGuest;

        guest = prepareGuest();

        if (guest == null) {
            System.out.println("Customer data input cancelled, returning to main menu");
            return guests;
        }

        if (guests.size() + 1 < hotelService.getRoomCapacity(roomNumber)) {
            guests.add(guest);
            System.out.println("Do you want to invite another guest (Y/N)?");
            if(getYesOrNoInput()){
                additionalGuest = prepareGuest();
                guests.add(additionalGuest);
                return guests;
            }


        } else {
            System.out.println("Maximum capacity reached");
            guests.add(guest);

            return guests;
        }


        return guests;
    }

    private Guest prepareGuest() {


        LocalDate birthday = prepareGuestBirthday();
        if (birthday == null) return null;
        String lName = prepareGuestLastName().toUpperCase().trim();
        if (lName == null) return null;

        String fName = prepareGuestFirstName().toUpperCase().trim();
        if (fName == null) return null;

        return new Guest(birthday, lName, fName);
    }

    private Guest prepareAdditionalGuest() {
        LocalDate birthday = prepareGuestBirthday();
        if (birthday == null) return null;
        String lName = prepareGuestLastName().toUpperCase().trim();
        if (lName == null) return null;

        String fName = prepareGuestFirstName().toUpperCase().trim();
        if (fName == null) return null;

        return new Guest(birthday, lName, fName);
    }

    private LocalDate prepareGuestBirthday() {
        System.out.println("Please input customer`s birthday in the dd.mm.yyyy format or 0 to go back to the main menu");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String birthday = ConsoleInput.getUserInputDate();
        if (birthday.equals("0")) {
            return null;
        } else {
            try {
                LocalDate birthdayLocalDate = LocalDate.parse(birthday, formatter);
                return birthdayLocalDate;
            } catch (Exception e) {
                System.out.println("Please input the birthday in the correct format or 0 to go back to the main menu");
                return prepareGuestBirthday();
            }
        }

    }


    private String prepareGuestLastName() {
        while (true) {
            System.out.println("Please input customer`s last name (only letters are allowed) or 0 to go back to the main menu");
            String lName = ConsoleInput.getUserInputString();
            if (lName.equals("0")) {
                return null;
            } else if (lName.matches("^[a-zA-Z]+$")) {
                return lName;
            } else {
                System.out.println("Incorrect input");
            }

        }
    }

    private String prepareGuestFirstName() {
        while (true) {
            System.out.println("Please input customer`s first name (only letters are allowed) or 0 to go back to the main menu");
            String fName = ConsoleInput.getUserInputString();
            if (fName.equals("0")) {
                return null;
            } else if (fName.matches("^[a-zA-Z]+$")) {
                return fName;
            } else {
                System.out.println("Incorrect input");
            }
        }


    }

    private boolean getYesOrNoInput() {
        String line = new Scanner(System.in).nextLine();
        if (line.equalsIgnoreCase("yes") || line.equalsIgnoreCase("y")) {
            return true;
        } else if (line.equalsIgnoreCase("no") || line.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Say yes or no");
            return getYesOrNoInput();
        }
    }


    void unregister() {
        System.out.println(MESSAGE_UNREGISTER);
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
