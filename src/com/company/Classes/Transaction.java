package com.company.Classes;

import java.util.Date;

public class Transaction {
    private Account fromAccount;
    private Account toAccount;
    private float amount;
    private float newBalance;
    private Date date;

    public Transaction() {}

    public Transaction(Account fromAccount, Account toAccount, float amount, float newBalance, Date date) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.newBalance = newBalance;
        this.date = date;
    }

    public Account getFromAccount() {
        return fromAccount;
    }
    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }
    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getNewBalance() {
        return newBalance;
    }
    public void setNewBalance(float newBalance) {
        this.newBalance = newBalance;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "fromAccount=" + fromAccount.toString() +
                ", toAccount=" + toAccount.toString() +
                ", amount=" + amount +
                ", newBalance=" + newBalance +
                ", date=" + date.toString() +
                '}';
    }
}
