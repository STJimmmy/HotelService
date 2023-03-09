package usermenu;

import hotelrooms.HotelService;

import java.util.Scanner;

public class RoomSubMenu {
    private boolean isRunning;
    private final String USER_SUBMENU_MESSAGE_RESERVE = "Please choose a room to reserve or 0 to go back to the main menu";
    private final String USER_SUBMENU_MESSAGE_RELEASE = "Please choose a room to release or 0 to go back to the main menu";

    private HotelService hotelService;

    public RoomSubMenu(HotelService hotelService) {
        this.hotelService = hotelService;
        System.out.println("usersubmenu created");
    }


    //public void run(int actionType) {
    //    do {
    //        showUserSubMenu(actionType);
    //        try {
    //            int userInput = getUserInput();
    //            processUserSelectionCheckIn(userInput, actionType);
    //        } catch (Exception e) {
    //            run(actionType);
    //        }
    //    } while (isRunning == true);
    //}

    public void run(int actionType) {

        while (isRunning == true) {
            showUserSubMenu(actionType);
            try {
                int userInput = getUserInput();
                processUserSelectionCheckIn(userInput, actionType);
            } catch (Exception e) {
                run(actionType);
            }
        }
        ;
    }

    private void showUserSubMenu(int actionType) {
        switch (actionType) {
            case (3):
                System.out.println(USER_SUBMENU_MESSAGE_RESERVE);
                break;
            default:
                System.out.println(USER_SUBMENU_MESSAGE_RELEASE);
        }
    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        if (input > hotelService.getHotelSize()) {
            System.out.println("There is no such room, please choose one of the rooms from the list");
            returnToMainMenu();
        }
        return input;
    }

    private void processUserSelectionCheckIn(int userInput, int actionType) {
        switch (userInput) {
            case 0:
                System.out.println("Returning to main menu");
                returnToMainMenu();
                break;
            default:
                if (actionType == 3) {
                    //hotelService.roomCheckin(hotelService.selectRoom(userInput), actionType);
                } else {
                   // hotelService.unregister(hotelService.selectRoom(userInput), actionType);
                }
        }

    }

    public void returnToMainMenu() {
        isRunning = false;
    }

    public void resetIsRunning() {
        isRunning = true;
    }
}

