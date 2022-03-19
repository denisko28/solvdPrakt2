package com.company.Classes;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
    private ArrayList<Account> accounts;
    private ArrayList<Credit> credits;

    public Customer() {}

    public Customer(
        ArrayList<Account> accounts,
        ArrayList<Credit> credits,
        String phone,
        String email,
        Date registerDate,
        String login,
        String password,
        String firstName,
        String lastName,
        String patronymic
    ){
        super(phone, email, registerDate, login, password, firstName, lastName, patronymic);
        this.accounts = accounts;
        this.credits = credits;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Credit> getLoans() {
        return credits;
    }
    public void setLoans(ArrayList<Credit> credits) {
        this.credits = credits;
    }

    public boolean addAccount(Account account){
        if(accounts != null)
        {
            return accounts.add(account);
        }else
            return false;
    }

    public boolean removeAccount(Account account){
        if(accounts != null)
        {
            return accounts.remove(account);
        }else
            return false;
    }

    public boolean addCredit(Credit account){
        if(credits != null)
        {
            return credits.add(account);
        }else
            return false;
    }

    public boolean removeCredit(Credit account){
        if(credits != null)
        {
            return credits.remove(account);
        }else
            return false;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountsNum=" + (accounts!=null ? accounts.size() : "null") +
                ", creditsNum=" + (credits!=null ? credits.size() : "null") +
                super.toString() +
                '}';
    }
}
