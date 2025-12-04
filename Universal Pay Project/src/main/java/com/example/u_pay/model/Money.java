package com.example.u_pay.model;

public class Money extends Account {
    private double savingAccount;

    public Money(String accountId, String accountFirstName, String accountLastName, String accountEmail, String accountNumber, int accountPin, double savingsAccount) {
        super(accountId, accountFirstName, accountLastName, accountEmail, accountNumber, accountPin);
        this.savingAccount = savingsAccount;
    }

    public double getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(double savingAccount) {
        this.savingAccount = savingAccount;
    }
}
