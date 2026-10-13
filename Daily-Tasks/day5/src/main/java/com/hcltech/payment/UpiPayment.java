
package com.hcltech.payment;

import java.math.BigDecimal;

public class UpiPayment extends Payment implements Refundable {

    public UpiPayment(String transactionId) {
        super(transactionId);
    }

    @Override
    public void pay(BigDecimal amount) {
        validateAmount(amount);
        System.out.println("Processing UPI payment: " + amount);
    }

    @Override
    public void refund(BigDecimal amount) {
        validateAmount(amount);
        System.out.println("Processing UPI refund: " + amount);
    }
}
