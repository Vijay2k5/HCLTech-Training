
package com.hcltech.orders.service;

import com.hcltech.orders.exception.InsufficientStockException;
import com.hcltech.orders.exception.InvalidQuantityException;

public class OrderProcessor {

    public void processOrder(
            String product,
            int availableStock,
            String quantityText
    ) throws InsufficientStockException {

        try {
            int quantity = parseQuantity(quantityText);

            if (quantity > availableStock) {
                throw new InsufficientStockException(
                    "Requested " + quantity + " units of " + product
                    + ", but only " + availableStock + " are available."
                );
            }

            System.out.println(
                "Order successful: " + quantity + " x " + product
            );

        } finally {
            // Runs on success and when an exception is thrown.
            System.out.println("Order processing audit completed.");
        }
    }

    private int parseQuantity(String quantityText) {
        final int quantity;

        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException | NullPointerException ex) {
            throw new InvalidQuantityException(
                "Quantity must be a valid whole number.", ex
            );
        }

        if (quantity <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero."
            );
        }

        return quantity;
    }
}
