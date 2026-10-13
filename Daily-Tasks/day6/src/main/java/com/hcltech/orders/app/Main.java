
package com.hcltech.orders.app;

import com.hcltech.orders.exception.InsufficientStockException;
import com.hcltech.orders.exception.InvalidQuantityException;
import com.hcltech.orders.service.OrderProcessor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\n=== Order Processor ===");
                System.out.println("1. Place order");
                System.out.println("2. Exit");
                System.out.print("Choose: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1" -> {
                        System.out.print("Product name: ");
                        String product = scanner.nextLine().trim();

                        System.out.print("Available stock: ");
                        int stock;

                        try {
                            stock = Integer.parseInt(
                                scanner.nextLine().trim()
                            );

                            if (stock < 0) {
                                System.out.println(
                                    "Stock cannot be negative."
                                );
                                continue;
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println(
                                "Stock must be a whole number."
                            );
                            continue;
                        }

                        System.out.print("Quantity: ");
                        String quantity = scanner.nextLine();

                        try {
                            processor.processOrder(
                                product, stock, quantity
                            );
                        } catch (InsufficientStockException ex) {
                            System.out.println(
                                "Order rejected: " + ex.getMessage()
                            );
                        } catch (InvalidQuantityException ex) {
                            System.out.println(
                                "Invalid input: " + ex.getMessage()
                            );

                            if (ex.getCause() != null) {
                                System.out.println(
                                    "Cause: "
                                    + ex.getCause().getClass().getSimpleName()
                                );
                            }
                        }
                    }

                    case "2" -> running = false;

                    default -> System.out.println(
                        "Invalid menu option. Try again."
                    );
                }
            }
        }

        System.out.println("Application closed.");
    }
}
