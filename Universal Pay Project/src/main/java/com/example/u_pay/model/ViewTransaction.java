package com.example.u_pay.model;

public class ViewTransaction {

    private double amount;
    private String name;
    private String accountId;
    private String dates;
    private String transferToId;
    private String transferFromId;

    public ViewTransaction() {}

    // Getters and Setters

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getTransferToId() {
        return transferToId;
    }

    public void setTransferToId(String transferToId) {
        this.transferToId = transferToId;
    }

    public String getTransferFromId() {
        return transferFromId;
    }

    public void setTransferFromId(String transferFromId) {
        this.transferFromId = transferFromId;
    }
}
