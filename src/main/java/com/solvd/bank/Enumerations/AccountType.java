package com.solvd.bank.Enumerations;

public enum AccountType {
    EXPENSES("Expenses"),
    DEPOSIT("Deposit"),
    SAVINGS("Savings");

    private final String value;

    AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
