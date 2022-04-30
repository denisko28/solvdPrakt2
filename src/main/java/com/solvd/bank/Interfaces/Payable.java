package com.solvd.bank.Interfaces;

import com.solvd.bank.Classes.Account;

public interface Payable {
    void pay(Account from, Account to, float amount, IPayCallBack callBackFunc);
}
