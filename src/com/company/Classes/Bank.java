package com.company.Classes;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Employee> employees;
    private ArrayList<Branch> branches;
    private ArrayList<Transaction> transactions;
    private ArrayList<Service> services;
    private ArrayList<Credit> credits;
    private Account depositAccount;
    private License license;

    public Bank() {}

    public Bank(
        String name,
        ArrayList<Customer> customers,
        ArrayList<Employee> employees,
        ArrayList<Branch> branches,
        ArrayList<Transaction> transactions,
        ArrayList<Service> services,
        ArrayList<Credit> credits,
        Account depositAccount,
        License license
    ) {
        this.name = name;
        this.customers = customers;
        this.employees = employees;
        this.branches = branches;
        this.transactions = transactions;
        this.services = services;
        this.credits = credits;
        this.depositAccount = depositAccount;
        this.license = license;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }
    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Service> getServices() {
        return services;
    }
    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public ArrayList<Credit> getCredits() {
        return credits;
    }
    public void setCredits(ArrayList<Credit> credits) {
        this.credits = credits;
    }

    public Account getDepositAccount() {
        return depositAccount;
    }
    public void setDepositAccount(Account depositAccount) {
        this.depositAccount = depositAccount;
    }

    public License getLicense() {
        return license;
    }
    public void setLicense(License license) {
        this.license = license;
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
        return "Bank{" +
                "name='" + name + "\'" +
                ", customersNum=" + (customers!=null ? customers.size() : "null") +
                ", employeesNum=" + (employees!=null ? employees.size() : "null") +
                ", branchesNum=" + (branches!=null ? branches.size() : "null") +
                ", transactionsNum=" + (transactions!=null ? transactions.size() : "null") +
                ", servicesNum=" + (services!=null ? services.size() : "null") +
                ", creditsNum=" + (credits!=null ? credits.size() : "null") +
                ", depositAccount=" + depositAccount.toString() +
                ", license=" + license.toString() +
                '}';
    }
}
