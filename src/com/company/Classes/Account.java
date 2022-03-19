package com.company.Classes;

import com.company.Enumerations.AccountType;

import java.util.Date;

public class Account {
    private String id;
    private Date openedDate;
    private AccountType accountType;
    private float currentBalance;

    public Account() {}

    public Account(String id, Date openedDate, AccountType accountType, float currentBalance) {
        this.id = id;
        this.openedDate = openedDate;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Date getOpenedDate() {
        return openedDate;
    }
    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + "\'" +
                ", openedDate=" + openedDate.toString() +
                ", accountType={" + accountType.toString() + "}" +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
