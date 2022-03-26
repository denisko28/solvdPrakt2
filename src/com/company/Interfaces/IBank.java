package com.company.Interfaces;

import com.company.Classes.Branch;
import com.company.Classes.Customer;
import com.company.Classes.Employee;
import com.company.Classes.Service;
import com.company.Classes.Transaction;

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
