package UserMenu;

import HotelRooms.HotelService;
import HotelRooms.Room;
import com.sun.tools.javac.Main;

import java.util.Scanner;

public class UserSubMenu {
    private boolean isRunning = true;
    static UserSubMenu userSubMenu = new UserSubMenu();
    private final String USERSUBMENUMESSAGERESERVE = "Please choose a room to reserve or 0 to go back to the main menu";
    private final String USERSUBMENUMESSAGERELEASE = "Please choose a room to release or 0 to go back to the main menu";

    public void run(int actionType) {
        do {
            showUserSubMenu(actionType);
            try {
                getUserInput(actionType);
            } catch (Exception e) {
                userSubMenu.run(actionType);
            }
        } while (isRunning == true);
    }

    private void showUserSubMenu(int actionType) {
        switch (actionType){
            case(3):
                System.out.println(USERSUBMENUMESSAGERESERVE);
                break;
            default:
                System.out.println(USERSUBMENUMESSAGERELEASE);
        }



    }

    private void getUserInput(int actionType) {
        Scanner scanner = new Scanner(System.in);
        Integer userInput = Integer.parseInt(scanner.nextLine());
        if (userInput > 15) {
            System.out.println("There is no such room, please choose one of the rooms from the list");
            userSubMenu.run(actionType);
        } else {
            processUserSelectionCheckIn(userInput, actionType);
        }


    }

    private void processUserSelectionCheckIn(int userInput, int actionType) {
        UserMenu userMenu = new UserMenu();
        HotelService hotelService = new HotelService();
        switch (userInput) {
            case 0:
                System.out.println("Returning to main menu");
                userMenu.run();

                break;
            default:
                if (actionType == 3) {

                    hotelService.roomCheckin(hotelService.selectRoom(userInput), actionType);

                } else {

                    hotelService.roomCheckout(hotelService.selectRoom(userInput), actionType);

                }


        }


    }


}

