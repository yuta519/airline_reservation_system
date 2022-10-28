package presentation;

import java.util.Scanner;

public class  StdIn {
    public static int decideService() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("Service 1 : Search destinations! From your location we suggest some destinations.");
        System.out.println("Service 2 : For Subtraction");
        System.out.println("Service 3 : For Division");
        System.out.println("==============================");

        return StdIn.validateInputInt(sc, "PLease enter a service number : ");
    }

    private static int validateInputInt(Scanner sc, String message) {
        boolean hasInt = false;
        int input = 0;
        do {
            System.out.println(message);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                hasInt = true;
            }
            sc.nextLine();
        } while(!hasInt);
        return input;
    }
}
