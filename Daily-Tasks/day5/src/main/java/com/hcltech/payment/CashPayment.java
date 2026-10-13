
package com.hcltech.payment;

import java.math.BigDecimal;

public class CashPayment extends Payment {

    public CashPayment(String transactionId) {
        super(transactionId);
    }

    @Override
    public void pay(BigDecimal amount) {
        validateAmount(amount);
        System.out.println("Recording cash payment: " + amount);
    }
}
