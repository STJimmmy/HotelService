package UserMenu;

import HotelRooms.HotelService;
import HotelRooms.Room;
import com.sun.tools.javac.Main;

import java.util.Scanner;

public class UserSubMenu {
    private boolean isRunning = true;
    private final String USERSUBMENUMESSAGERESERVE = "Please choose a room to reserve or 0 to go back to the main menu";
    private final String USERSUBMENUMESSAGERELEASE = "Please choose a room to release or 0 to go back to the main menu";

    private HotelService hotelService;

    public UserSubMenu(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    public void run(int actionType) {
        do {
            showUserSubMenu(actionType);
            try {
                int userInput = getUserInput();
                processUserSelectionCheckIn(userInput, actionType);
            } catch (Exception e) {
                run(actionType);
            }
        } while (isRunning == true);
    }

    private void showUserSubMenu(int actionType) {
        switch (actionType) {
            case (3):
                System.out.println(USERSUBMENUMESSAGERESERVE);
                break;
            default:
                System.out.println(USERSUBMENUMESSAGERELEASE);
        }
    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        if (input > hotelService.getHotelSize()) {
            System.out.println("There is no such room, please choose one of the rooms from the list");
            getUserInput();
        }
       return input;
    }

    private void processUserSelectionCheckIn(int userInput, int actionType) {
        switch (userInput) {
            case 0:
                System.out.println("Returning to main menu");
                isRunning = false;
                break;
            default:
                if (actionType == 3) {
                    hotelService.roomCheckin(hotelService.selectRoom(userInput));
                } else {
                    hotelService.roomCheckout(hotelService.selectRoom(userInput), actionType);
                }
        }
    }


}

