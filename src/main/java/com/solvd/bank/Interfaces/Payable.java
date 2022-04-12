package com.solvd.bank.Interfaces;

import com.solvd.bank.Classes.Account;
import com.solvd.bank.Classes.Transaction;

public interface Payable {
    public Transaction pay(Account from, Account to, float amount);
}
