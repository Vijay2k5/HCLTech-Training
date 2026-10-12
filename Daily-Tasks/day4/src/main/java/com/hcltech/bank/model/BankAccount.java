
package com.hcltech.bank.model;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {

    private final String accountNumber;
    private final String ownerName;
    private BigDecimal balance;

    private static int accountCount = 0;

    // Constructor 1: default opening balance
    public BankAccount(String accountNumber, String ownerName) {
        this(accountNumber, ownerName, BigDecimal.ZERO);
    }

    // Constructor 2: opening balance supplied as a decimal
    public BankAccount(
            String accountNumber,
            String ownerName,
            double openingBalance) {
        this(
            accountNumber,
            ownerName,
            BigDecimal.valueOf(openingBalance)
        );
    }

    // Constructor 3: central validation and initialization
    public BankAccount(
            String accountNumber,
            String ownerName,
            BigDecimal openingBalance) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Account number cannot be empty.");
        }

        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException(
                    "Owner name cannot be empty.");
        }

        Objects.requireNonNull(
                openingBalance, "Opening balance is required.");

        if (openingBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Opening balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
        accountCount++;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public void deposit(BigDecimal amount) {
        validatePositiveAmount(amount);
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        validatePositiveAmount(amount);

        if (amount.compareTo(balance) < 0) {  // breakpoint
            throw new IllegalArgumentException(
                    "Insufficient balance.");
        }

        balance = balance.subtract(amount);
    }

    private void validatePositiveAmount(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount is required.");

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof BankAccount other)) {
            return false;
        }

        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }

    @Override
    public String toString() {
        return "BankAccount{accountNumber='"
                + accountNumber
                + "', ownerName='"
                + ownerName
                + "', balance="
                + balance
                + "}";
    }
}
