package com.example.Gcash.App.model;

public class Account {
    private String accountId;
    private String name;
    private String email;
    private String number;
    private String pin;

    public Account(String accountId, String name, String email, String number, String pin) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.number = number;
        this.pin = pin;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }
}
