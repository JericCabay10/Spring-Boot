package com.example.u_pay.model;



import com.example.u_pay.utils.IdGenerators;
import com.example.u_pay.utils.RoleGenerators;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class Account {
    private String accountId;
    private String accountRole;
    private String accountFirstName;
    private String accountLastName;
    private String accountEmail;
    private String accountNumber;
    private int accountPin;

    public Account(String accountId, String accountFirstName, String accountLastName, String accountEmail, String accountNumber, int accountPin) {
        this.accountId = accountId;
        this.accountFirstName = accountFirstName;
        this.accountLastName = accountLastName;
        this.accountEmail = accountEmail;
        this.accountNumber = accountNumber;
        this.accountPin = accountPin;
    }

    public Account() {
        this.accountId = IdGenerators.generateId();
        this.accountRole = RoleGenerators.rolePick();
    }

    public void setAccountId(String accountId) {this.accountId = accountId;}

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountRole(String role) { this.accountRole = accountRole; }

    public String getAccountRole() { return this.accountRole; }

    public void setAccountFirstName(String accountFirstName) {
        this.accountFirstName = accountFirstName;
    }

    public String getAccountFirstName() {
        return this.accountFirstName;
    }

    public void setAccountLastName(String accountLastName) {
        this.accountLastName = accountLastName;
    }

    public String getAccountLastName() {
        return this.accountLastName;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountEmail() {
        return this.accountEmail;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public int getAccountPin() {
        return this.accountPin;
    }


}
