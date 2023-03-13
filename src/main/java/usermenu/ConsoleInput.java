package usermenu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Scanner;

class ConsoleInput {

    static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    static LocalDate getUserInputDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);
        return LocalDate.parse(scanner.nextLine(), formatter);
    }
    static String getUserInputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
