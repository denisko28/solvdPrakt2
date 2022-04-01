package com.company.Exceptions;

public class FutureDateException extends Exception {
    public FutureDateException() {
        super("This date can not be in the future");
    }
}
