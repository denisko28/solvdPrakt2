package com.company.Interfaces;

import com.company.Classes.Account;
import com.company.Classes.Transaction;

public interface Payable {
    public Transaction pay(Account from, Account to, float amount);
}
