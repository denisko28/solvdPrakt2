package com.solvd.bank.Classes;

import com.solvd.bank.Enumerations.AccountType;
import com.solvd.bank.Exceptions.ExpiredLicenseException;
import com.solvd.bank.Interfaces.IBank;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;

public class Bank implements IBank {
    private static final Logger LOGGER = Logger.getLogger(Bank.class);

    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Employee> employees;
    private ArrayList<Branch> branches;
    private ArrayList<Transaction> transactions;
    private ArrayList<Service> services;
    private ArrayList<Credit> credits;
    private ArrayList<Account> accounts;
    private Account depositAccount;
    private License license;

    public Bank() {}

    public Bank(String name, ArrayList<Customer> customers, ArrayList<Employee> employees, ArrayList<Branch> branches,
                ArrayList<Transaction> transactions, ArrayList<Service> services, ArrayList<Credit> credits,
                ArrayList<Account> accounts, Account depositAccount, License license ) {
        this.name = name;
        this.customers = customers;
        this.employees = employees;
        this.branches = branches;
        this.transactions = transactions;
        this.services = services;
        this.credits = credits;
        this.accounts = accounts;
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

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
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
        try {
            Date currentDate = new Date();
            if(!license.getExpireDate().before(currentDate))
                this.license = license;
            else
                throw new ExpiredLicenseException("You are trying to set an expired license");
        } catch (ExpiredLicenseException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }

    public boolean addCustomer(Customer customer){
        if(customers != null)
        {
            return customers.add(customer);
        }else
            return false;
    }

    public boolean removeCustomer(Customer customer){
        if(customers != null)
        {
            return customers.remove(customer);
        }else
            return false;
    }

    public boolean addEmployee(Employee employee){
        if(employees != null)
        {
            return employees.add(employee);
        }else
            return false;
    }

    public boolean removeEmployee(Employee employee){
        if(employees != null)
        {
            return employees.remove(employee);
        }else
            return false;
    }

    public boolean addBranch(Branch branch){
        if(branches != null)
        {
            return branches.add(branch);
        }else
            return false;
    }

    public boolean removeBranch(Branch branch){
        if(branches != null)
        {
            return branches.remove(branch);
        }else
            return false;
    }

    public boolean addTransaction(Transaction transaction){
        if(transactions != null)
        {
            return transactions.add(transaction);
        }else
            return false;
    }

    public boolean addService(Service service){
        if(services != null)
        {
            return services.add(service);
        }else
            return false;
    }

    public boolean removeService(Service service){
        if(services != null)
        {
            return services.remove(service);
        }else
            return false;
    }

    public boolean addCredit(Credit credit){
        if(credits != null)
        {
            return credits.add(credit);
        }else
            return false;
    }

    public boolean removeCredit(Credit credit){
        if(credits != null)
        {
            return credits.remove(credit);
        }else
            return false;
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

    public void openAccountForCustomer(Employee employee, Customer customer, AccountType accountType){
        Account account = employee.openAccountForCustomer(accountType);
        customer.addAccount(account);
        this.addAccount(account);
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
