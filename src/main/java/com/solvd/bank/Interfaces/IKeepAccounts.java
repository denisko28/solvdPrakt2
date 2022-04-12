package com.solvd.bank.Interfaces;

import com.solvd.bank.Classes.Account;

public interface IKeepAccounts {
    public boolean addAccount(Account account);

    public boolean removeAccount(Account account);
}
