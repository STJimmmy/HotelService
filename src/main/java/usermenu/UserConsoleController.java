package usermenu;

import hotelrooms.HotelService;
import hotelrooms.Room;

public class UserConsoleController {

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

    private final HotelService hotelService;
    private final RegisterConsoleController registerController;

    public UserConsoleController(HotelService hotelService, RegisterConsoleController registerController) {
        this.hotelService = hotelService;
        this.registerController = registerController;
    }

    public void run() {
        while (isRunning) {
            showUserMenu();
            try {
                int input = ConsoleInput.getUserInput();
                processUserSelection(input);
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println(INPUTERRORMESSAGE);
            }
        }
    }

    private void showUserMenu() {
        System.out.println(USERMENUMESSAGE);

    }



    private void processUserSelection(int userInput) {
        switch (userInput) {
            case 1:
                displayAllRooms();
                break;
            case 2:
                displayVacantRooms();
                break;
            case 3:
               registerController.register();
                break;
            case 4:
                registerController.unregister();
                break;
            case 5:
              //  terminateProgram();
                break;
            default:
                System.out.println(INPUTERRORMESSAGE);
        }
    }

    private void displayAllRooms() {
        //iter
        for (Room room : hotelService.getRooms()) {
            System.out.println(getRoomInfo(room));
        }
    }


    private String booleanTranslate(boolean value) {
        return value ? "Y" : "N";
    }

    private void displayVacantRooms() {
        hotelService.getVacantRooms()
                .forEach(room -> System.out.println(getRoomInfo(room)));
    }

    private String getRoomInfo(Room room) {
      return   "Room Number: " + room.getRoomNo() +
                ", Capacity: " + room.getCapacity() +
                ", BathRoom: " + booleanTranslate(room.isThereBathRoom()) +
                ", Vacant: " + booleanTranslate(room.isVacant());
    }


  /*  private void processUserSelectionCheckIn(int userInput) {
        switch (userInput) {
            case 0:
                System.out.println("Returning to main menu");
                returnToMainMenu();
                break;
            default:
                if (actionType == 3) {
                    hotelService.roomCheckin(hotelService.selectRoom(userInput), actionType);
                } else {
                    hotelService.roomCheckout(hotelService.selectRoom(userInput), actionType);
                }
        }

    }
     List<Room> collect = rooms.stream()
                .collect(Collectors.toList());

        List<Room> myList = new ArrayList<>(collect);*




    void terminateProgram() {
        isRunning = false;
        System.out.println("Program has ended");
    }*/
}
