
package com.hcltech.payment;

import java.math.BigDecimal;

public class CardPayment extends Payment implements Refundable {

    public CardPayment(String transactionId) {
        super(transactionId);
    }

    @Override
    public void pay(BigDecimal amount) {
        validateAmount(amount);
        System.out.println("Processing card payment: " + amount);
    }

    @Override
    public void refund(BigDecimal amount) {
        validateAmount(amount);
        System.out.println("Processing card refund: " + amount);
    }
}
