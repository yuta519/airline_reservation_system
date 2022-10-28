package utils;

import java.util.Scanner;

public class StdIn {
    public static int validate_input_int(Scanner sc, String message) {
        boolean hasInt = false;
        int input = 0;
        do {
            System.out.printf("%s%s%s", ConsoleColors.CYAN_BACKGROUND, message, ConsoleColors.RESET);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                hasInt = true;
            }
            sc.nextLine();
        } while(!hasInt);
        return input;
    }
}
