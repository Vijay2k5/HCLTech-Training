
package com.hcltech.bank.app;

import com.hcltech.bank.model.BankAccount;
import com.hcltech.bank.service.BankAccountService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        BankAccount account1 =
                new BankAccount("ACC1001", "Ravi");

        BankAccount account2 =
                new BankAccount("ACC1002", "Priya",
                        new BigDecimal("5000.00"));

        BankAccount account3 =
                new BankAccount("ACC1001", "Kavi",
                        new BigDecimal("1000.00"));

        BankAccountService service =
                new BankAccountService();

        service.deposit(account1, new BigDecimal("1500.00"));
        service.withdraw(account1, new BigDecimal("200.00"));

        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);
        System.out.println("Account 3: " + account3);

        System.out.println("Account 1 balance: "
                + service.getBalance(account1));

        System.out.println("Total accounts created: "
                + BankAccount.getAccountCount());


        System.out.println("Same account identity: "
                + account1.equals(account3));

        System.out.println("Same hash code: "
                + (account1.hashCode() == account3.hashCode()));
    }
}
