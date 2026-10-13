
package com.hcltech.payment;

import java.math.BigDecimal;

public class PaymentService {

    public void pay(Payment payment, BigDecimal amount) {
        payment.pay(amount);
    }

    public void pay(
            Payment payment,
            BigDecimal amount,
            String reference
    ) {
        if (reference == null || reference.isBlank()) {
            throw new IllegalArgumentException(
                "Payment reference is required"
            );
        }

        System.out.println("Reference: " + reference);
        payment.pay(amount);
    }
}
