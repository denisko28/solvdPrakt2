package com.company.Exceptions;

public class NegativeBalanceException  extends Exception {
    public NegativeBalanceException () {
        super("Balance can not be negative");
    }
}
