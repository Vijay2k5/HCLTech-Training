
package com.hcltech.bank.service;

import com.hcltech.bank.model.BankAccount;
import java.math.BigDecimal;

public class BankAccountService {

    public void deposit(
            BankAccount account, BigDecimal amount) {
        account.deposit(amount);
    }

    public void withdraw(
            BankAccount account, BigDecimal amount) {
        account.withdraw(amount);
    }

    public BigDecimal getBalance(BankAccount account) {
        return account.getBalance();
    }
}
