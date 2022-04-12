package com.solvd.bank.Interfaces;

import com.solvd.bank.Classes.Credit;

public interface IKeepCredits {
    public boolean addCredit(Credit credit);

    public boolean removeCredit(Credit credit);
}
