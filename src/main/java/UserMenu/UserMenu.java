package UserMenu;

import HotelRooms.HotelService;

import java.util.Scanner;

public class UserMenu {

    HotelService hotelService = new HotelService();
    UserSubMenu userSubMenu = new UserSubMenu();
    private final String USERMENUMESSAGE = """
            Choose one of the options:
            1. Show all rooms.
            2. Show all available rooms.
            3. Reserve a room (please specify room no and reserve it if it`s available).
            4. Checkout (please specify room no and checkout it if it`s occupied).
            5. Exit program.
            """;
    private final String CHECKINMESSAGE = """
            Choose the room where you want to check in your guest or enter 0 to go back to the main menu.       
                    """;
    private final String CHECKOUTMESSAGE = """
            Choose the room where you want to check out your guest or enter 0 to go back to the main menu.       
                    """;

    private final String INPUTERRORMESSAGE = "You should indicate a number 1-5";

    private boolean isRunning = true;


    public void run() {

        do {
            showUserMenu();
            try {
                getUserInput();
            } catch (Exception e) {

            }

        } while (isRunning);

    }

    private void showUserMenu() {
        System.out.println(USERMENUMESSAGE);

    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        Integer userInput = Integer.parseInt(scanner.nextLine());
        processUserSelection(userInput);

    }

    private int getUserInputRoomChoice() {
        Scanner scanner = new Scanner(System.in);


        Integer userInput = Integer.parseInt(scanner.nextLine());
            return userInput;


        }



    public int roomChooseCheckIn() {
        System.out.println(CHECKINMESSAGE);
        int userInput = getUserInputRoomChoice();
return userInput;
    }
    public int roomChooseCheckOut() {
        System.out.println(CHECKOUTMESSAGE);
        int userInput = getUserInputRoomChoice();
        return userInput;
    }

    void terminateProgram() {
        isRunning = false;
        System.out.println("Program has ended");
    }
void endCurrentCycle(){
    isRunning = false;
}
    private void processUserSelection(int userInput) {

        switch (userInput) {

            case 1:
                hotelService.displayAllRooms();
                break;
            case 2:
                hotelService.displayVacantRooms();
                break;
            case 3:
                userSubMenu.run(userInput);
                break;
            case 4:
                userSubMenu.run(userInput);
                break;
            case 5:
                terminateProgram();
                break;

            default:
                System.out.println(INPUTERRORMESSAGE);
        }


    }


}
