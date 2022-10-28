package presentation;

import java.util.Scanner;

import utils.StdIn;

public class  Init {
    public Scanner scan;

    public Init() {
        this.scan =  new Scanner(System.in);
        this.decide_service();
    }

    public void decide_service() {
        System.out.println("==============================");
        System.out.println("Service 1 : Search destinations! From your location, we suggest some destinations.");
        System.out.println("Service 2 : Search flight offers! ");
        System.out.println("Service 3 : For Division");
        System.out.println("To terminate this app, please input 0");
        System.out.println("==============================");

        int choice = StdIn.validate_input_int(this.scan, "PLease enter a service number : ");

        if (choice == 1) {
            Destinations.search(this.scan);
            this.decide_service();
        }
        if (choice == 2) {
            Destinations.search(this.scan);
            this.decide_service();
        }
        if (choice == 3) {
            Destinations.search(this.scan);
            this.decide_service();
        }

        if (choice == 0) {
            System.out.println("Thank you for using this appp. Terminating service...");
            scan.close();
            return;
        }
    }
}
