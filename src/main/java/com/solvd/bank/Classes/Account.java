package com.solvd.bank.Classes;

import com.solvd.bank.Enumerations.AccountType;
import com.solvd.bank.Exceptions.FutureDateException;
import com.solvd.bank.Exceptions.NegativeBalanceException;
import org.apache.log4j.Logger;

import java.util.Date;

public class Account {
    private static final Logger LOGGER = Logger.getLogger(Account.class);

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
        try {
            Date currentDate = new Date();
            if (!openedDate.after(currentDate))
                this.openedDate = openedDate;
            else
                throw new FutureDateException();
        } catch (FutureDateException ex) {
            LOGGER.debug(ex.getMessage());
        }
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
        try {
            if (currentBalance >= 0)
                this.currentBalance = currentBalance;
            else
                throw new NegativeBalanceException();
        } catch (NegativeBalanceException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }

    public Employee getOpenedBy() {
        return openedBy;
    }

    public void setOpenedBy(Employee openedBy) {
        this.openedBy = openedBy;
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
