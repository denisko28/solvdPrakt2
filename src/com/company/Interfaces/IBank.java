package com.company.Interfaces;

import com.company.Classes.*;

public interface IBank extends IKeepAccounts, IKeepCredits {
    public boolean addCustomer(Customer customer);

    public boolean removeCustomer(Customer customer);

    public boolean addEmployee(Employee employee);

    public boolean removeEmployee(Employee employee);

    public boolean addBranch(Branch branch);

    public boolean removeBranch(Branch branch);

    public boolean addTransaction(Employee employee);

    public boolean addService(Service service);

    public boolean removeService(Service service);
}
