package com.solvd.bank.Exceptions;

public class ExpiredLicenseException extends Exception{
    public ExpiredLicenseException(String message) {
        super(message);
    }
}
