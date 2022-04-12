package com.solvd.bank.Classes;

public class Service {
    private String name;
    private Account account;

    public Service() {}

    public Service(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", account=" + account.toString() +
                '}';
    }
}
