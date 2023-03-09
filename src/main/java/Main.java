import hotelrooms.HotelService;
import usermenu.RegisterConsoleController;
import usermenu.UserConsoleController;

public class Main {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();
        RegisterConsoleController registerController = new RegisterConsoleController(hotelService);
        UserConsoleController userConsoleController = new UserConsoleController(hotelService,registerController);
        userConsoleController.run();

    }
}
