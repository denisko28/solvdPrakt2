package com.solvd.bank.Interfaces;

import com.solvd.bank.Classes.Branch;
import com.solvd.bank.Classes.Customer;
import com.solvd.bank.Classes.Employee;
import com.solvd.bank.Classes.Service;
import com.solvd.bank.Classes.Transaction;

public interface IBank extends IKeepAccounts, IKeepCredits {
    public boolean addCustomer(Customer customer);

    public boolean removeCustomer(Customer customer);

    public boolean addEmployee(Employee employee);

    public boolean removeEmployee(Employee employee);

    public boolean addBranch(Branch branch);

    public boolean removeBranch(Branch branch);

    public boolean addTransaction(Transaction transaction);

    public boolean addService(Service service);

    public boolean removeService(Service service);
}
