package com.company.Exceptions;

import java.util.Date;

public class EarlierDateException extends Exception {
    public EarlierDateException(Date comparedDate) {
        super("The date cannot be earlier then " + comparedDate.toString());
    }
}
