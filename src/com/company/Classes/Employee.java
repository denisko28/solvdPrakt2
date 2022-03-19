package com.company.Classes;

import com.company.Enumerations.AccountType;
import com.company.Enumerations.EmployeeType;

import java.util.Date;
import java.util.Random;

public class Employee extends User {
    private EmployeeType employeeType;
    private Address address;

    public Employee() {}

    public Employee(EmployeeType employeeType, Address address, String phone, String email, Date registerDate,
                    String login, String password, String firstName, String lastName, String patronymic ) {
        super(phone, email, registerDate, login, password, firstName, lastName, patronymic);
        this.employeeType = employeeType;
        this.address = address;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Account openAccountForCustomer(AccountType accountType){
        Random random = new Random();
        String accountId = '#' + Integer.toString(random.nextInt(5000));
        Account account = new Account(accountId, new Date(), accountType, 0, this);
        return account;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeType=" + employeeType.toString() +
                ", address=" + address.toString() +
                super.toString() +
                '}';
    }
}
