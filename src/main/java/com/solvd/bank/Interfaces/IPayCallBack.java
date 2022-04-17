package com.solvd.bank.Interfaces;

import com.solvd.bank.Classes.Transaction;

@FunctionalInterface
public interface IPayCallBack {
    void callback(Transaction transaction);
}
