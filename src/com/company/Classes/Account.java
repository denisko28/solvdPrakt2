package com.company.Classes;

import com.company.Enumerations.AccountType;

import java.util.Date;

public class Account {
    private String id;
    private Date openedDate;
    private AccountType accountType;
    private float currentBalance;
    private Employee openedBy;

    public Account() {}

    public Account(String id, Date openedDate, AccountType accountType, float currentBalance, Employee openedBy) {
        this.id = id;
        this.openedDate = openedDate;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
        this.openedBy = openedBy;
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

    public void setOpenedBy(Employee openedBy) {
        this.openedBy = openedBy;
    }
    public Employee getOpenedBy() {
        return openedBy;
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
