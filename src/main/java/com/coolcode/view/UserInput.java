package com.coolcode.view;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumberBetween(int min, int max) {
        while (true) {
            System.out.printf(
                    "Please provide the number between %s and %s: ",
                    min, max
            );
            int choice  = scanner.nextInt();
            scanner.nextLine();

            if (choice >= min && choice <= max) {
                return choice;
            }
            System.out.println("Invalid choice. Please try agin.");
        }

    }


}
