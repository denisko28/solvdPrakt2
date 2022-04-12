package com.solvd.bank.Classes;

import java.util.Date;

public class Credit {
    private String id;
    private Customer borrower;
    private Branch branch;
    private float amountBorrowed;
    private float amountLeftToPay;
    private int daysToRepay;
    private int percent;
    private Date borrowingDate;

    public Credit() {}

    public Credit(String id, Customer borrower, Branch branch, float amountBorrowed, float amountLeftToPay,
                  int daysToRepay, int percent, Date borrowingDate ) {
        this.id = id;
        this.borrower = borrower;
        this.branch = branch;
        this.amountBorrowed = amountBorrowed;
        this.amountLeftToPay = amountLeftToPay;
        this.daysToRepay = daysToRepay;
        this.percent = percent;
        this.borrowingDate = borrowingDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getBorrower() {
        return borrower;
    }

    public void setBorrower(Customer borrower) {
        this.borrower = borrower;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public float getAmountBorrowed() {
        return amountBorrowed;
    }

    public void setAmountBorrowed(float amountBorrowed) {
        this.amountBorrowed = amountBorrowed;
    }

    public float getAmountLeftToPay() {
        return amountLeftToPay;
    }

    public void setAmountLeftToPay(float amountLeftToPay) {
        this.amountLeftToPay = amountLeftToPay;
    }

    public int getDaysToRepay() {
        return daysToRepay;
    }

    public void setDaysToRepay(int daysToRepay) {
        this.daysToRepay = daysToRepay;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id='" + id + '\'' +
                ", borrower=" + borrower.toString() +
                ", branch=" + branch.toString() +
                ", amountBorrowed=" + amountBorrowed +
                ", amountLeftToPay=" + amountLeftToPay +
                ", daysToRepay=" + daysToRepay +
                ", percent=" + percent +
                ", borrowingDate=" + borrowingDate.toString() +
                '}';
    }
}
