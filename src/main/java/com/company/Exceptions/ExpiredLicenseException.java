package com.company.Exceptions;

public class ExpiredLicenseException extends Exception{
    public ExpiredLicenseException(String message) {
        super(message);
    }
}
