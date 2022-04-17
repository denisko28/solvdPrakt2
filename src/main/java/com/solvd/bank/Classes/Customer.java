package com.solvd.bank.Classes;

import org.apache.log4j.Logger;

import com.solvd.bank.Interfaces.IPayCallBack;
import com.solvd.bank.Interfaces.IKeepAccounts;
import com.solvd.bank.Interfaces.IKeepCredits;
import com.solvd.bank.Interfaces.Payable;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends User implements IKeepAccounts, IKeepCredits, Payable {
    private static final Logger LOGGER = Logger.getLogger(Customer.class);

    private ArrayList<Account> accounts;
    private ArrayList<Credit> credits;

    public Customer() {}

    public Customer(ArrayList<Account> accounts, ArrayList<Credit> credits, String phone, String email, Date registerDate,
                    String login, String password, String firstName, String lastName, String patronymic ){
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

    public boolean ownsAccount(Account account) {
        return accounts.contains(account);
    }

    @Override
    public void pay(Account from, Account to, float amount, IPayCallBack callBackFunc){
        try {
            if(from != null || to != null) {
                if(amount > 0) {
                    if(ownsAccount(from)) {
                        float newBalanceFrom = from.getCurrentBalance() - amount;
                        if(newBalanceFrom >= 0) {
                            float newBalanceTo = to.getCurrentBalance() + amount;
                            from.setCurrentBalance(newBalanceFrom);
                            to.setCurrentBalance(newBalanceTo);
                            callBackFunc.callback(new Transaction(from, to, amount, newBalanceFrom, newBalanceTo, new Date()));
                        } else
                            throw new IllegalArgumentException("The account from which goes payment doesn't have enough money");
                    } else
                        throw new IllegalArgumentException("This customer doesn't own Account with id: '" + from.getId() + "'");
                } else
                    throw new IllegalArgumentException("The amount should be greater then 0");
            } else
                throw new NullPointerException("Accounts cannot be null");
        } catch (RuntimeException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }

    @Override
    public void sendMessage() {
        System.out.println("Hello, I am customer");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountsNum=" + (accounts!=null ? accounts.size() : "null") +
                ", creditsNum=" + (credits!=null ? credits.size() : "null") +
                ", " + super.toString() +
                '}';
    }
}
