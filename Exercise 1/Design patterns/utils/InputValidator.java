// utils/InputValidator.java
package utils;

import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator() {
        scanner = new Scanner(System.in);
    }

    public int getValidatedInteger(String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return number;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
