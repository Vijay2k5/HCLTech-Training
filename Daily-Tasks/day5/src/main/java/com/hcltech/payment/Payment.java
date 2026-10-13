
package com.hcltech.payment;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Payment {
    private final String transactionId;

    protected Payment(String transactionId) {
        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException(
                "Transaction ID cannot be empty"
            );
        }
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    protected void validateAmount(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount is required");

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                "Amount must be greater than zero"
            );
        }
    }

    public abstract void pay(BigDecimal amount);
}
