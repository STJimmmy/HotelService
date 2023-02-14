package UserMenu;

import HotelRooms.HotelService;

import java.util.Scanner;

public class UserMenu {

    private final HotelService hotelService = new HotelService();
    private final UserSubMenu userSubMenu = new UserSubMenu(hotelService);
    private static final String USERMENUMESSAGE = """
            Choose one of the options:
            1. Show all rooms.
            2. Show all available rooms.
            3. Reserve a room (please specify room no and reserve it if it`s available).
            4. Checkout (please specify room no and checkout it if it`s occupied).
            5. Exit program.
            """;
    private static final String CHECKINMESSAGE = """
            Choose the room where you want to check in your guest or enter 0 to go back to the main menu.       
                    """;
    private static final String CHECKOUT_MESSAGE = """
            Choose the room where you want to check out your guest or enter 0 to go back to the main menu.       
                    """;

    private static final String INPUTERRORMESSAGE = "You should indicate a number 1-5";

    private boolean isRunning = true;


    public void run() {
        do {
            showUserMenu();
            try {
                int input = getUserInput();
                processUserSelection(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (isRunning);
    }

    private void showUserMenu() {
        System.out.println(USERMENUMESSAGE);

    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private void processUserSelection(int userInput) {
        switch (userInput) {
            case 1 -> hotelService.displayAllRooms();
            case 2 -> hotelService.displayVacantRooms();
            case 3, 4 -> userSubMenu.run(userInput);
            case 5 -> terminateProgram();
            default -> System.out.println(INPUTERRORMESSAGE);
        }
    }

    void terminateProgram() {
        isRunning = false;
        System.out.println("Program has ended");
    }
}
