package usermenu;

import java.util.Scanner;

 class ConsoleInput {

     static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

}
