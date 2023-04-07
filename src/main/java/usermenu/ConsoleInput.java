package usermenu;

import hotelrooms.HotelServiceException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Scanner;

class ConsoleInput {

    static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    static String getUserInputDate() {


            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

        return input;

}


    static String getUserInputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
