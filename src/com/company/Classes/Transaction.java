package com.company.Classes;

import com.company.Interfaces.ComparableTransaction;

import java.util.Date;

public class Transaction implements ComparableTransaction {
    private Account fromAccount;
    private Account toAccount;
    private float amount;
    private float newBalanceFrom;
    private float newBalanceTo;
    private Date date;

    public Transaction() {}

    public Transaction(Account fromAccount, Account toAccount, float amount, float newBalanceFrom, float newBalanceTo,
                       Date date) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.newBalanceFrom = newBalanceFrom;
        this.newBalanceTo = newBalanceTo;
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

    public float getNewBalanceFrom() {
        return newBalanceFrom;
    }
    public void setNewBalanceFrom(float newBalance) {
        this.newBalanceFrom = newBalance;
    }

    public float getNewBalanceTo() {
        return newBalanceTo;
    }
    public void setNewBalanceTo(float newBalance) {
        this.newBalanceTo = newBalance;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public int compareTransaction(Transaction anotherTransaction) {
        if(this.amount < anotherTransaction.amount)
            return -1;
        else if(this.amount > anotherTransaction.amount)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "fromAccount=" + fromAccount.toString() +
                ", toAccount=" + toAccount.toString() +
                ", amount=" + amount +
                ", newBalanceFrom=" + newBalanceFrom +
                ", newBalanceTo=" + newBalanceTo +
                ", date=" + date.toString() +
                '}';
    }
}
