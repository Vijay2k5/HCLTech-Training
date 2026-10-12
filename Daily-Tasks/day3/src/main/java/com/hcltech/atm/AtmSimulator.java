
package com.hcltech.atm;

import java.util.Scanner;

public class AtmSimulator {

    private static final int CORRECT_PIN = 1234;
    private static final int MAX_ATTEMPTS = 3;

    private static double balance = 1000.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== WELCOME TO HCL ATM =====");

        if (!authenticate(scanner)) {
            System.out.println("Too many incorrect attempts. Card blocked.");
            scanner.close();
            return;
        }

        boolean running = true;

        while (running) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.printf("Current balance: Rs. %.2f%n", balance);
                    break;

                case 2:
                    deposit(scanner);
                    break;

                case 3:
                    withdraw(scanner);
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for using HCL ATM.");
                    break;

                default:
                    System.out.println("Invalid option. Choose 1 to 4.");
            }
        }

        scanner.close();
    }

    private static boolean authenticate(Scanner scanner) {
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Enter your 4-digit PIN: ");
            String enteredPin = scanner.nextLine().trim();

            if (enteredPin.matches("\\d{4}")
                    && Integer.parseInt(enteredPin) == CORRECT_PIN) {
                System.out.println("PIN verified successfully.");
                return true;
            }

            System.out.println(
                    "Incorrect PIN. Attempts remaining: "
                            + (MAX_ATTEMPTS - attempt));
        }

        return false;
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter deposit amount: Rs. ");
        double amount = readAmount(scanner);

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        balance += amount;
        System.out.printf("Deposit successful. New balance: Rs. %.2f%n",
                balance);
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount: Rs. ");
        double amount = readAmount(scanner);

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf(
                    "Withdrawal successful. New balance: Rs. %.2f%n",
                    balance);
        }
    }

    private static double readAmount(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
