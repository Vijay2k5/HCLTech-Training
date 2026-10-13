
package com.hcltech.payment;

import java.math.BigDecimal;

public class PaymentDemo {

    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        Payment[] payments = {
            new CardPayment("TXN101"),
            new UpiPayment("TXN102"),
            new CashPayment("TXN103")
        };

        for (Payment payment : payments) {
            service.pay(payment, new BigDecimal("500.00"));
        }

        service.pay(
            new UpiPayment("TXN104"),
            new BigDecimal("250.00"),
            "PARKING-BOOKING-501"
        );

        Refundable refundable = new CardPayment("TXN105");
        refundable.refund(new BigDecimal("100.00"));
    }
}
