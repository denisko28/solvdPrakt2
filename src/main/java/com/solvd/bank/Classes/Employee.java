package com.solvd.bank.Classes;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import com.solvd.bank.Enumerations.AccountType;
import com.solvd.bank.Enumerations.EmployeeType;
import com.solvd.bank.Interfaces.Calculable;

import java.util.Date;

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

    public final Account openAccountForCustomer(AccountType accountType){
        String accountId = '#' + Integer.toString(RandomUtils.nextInt(0, 10000));
        return new Account(accountId, new Date(), accountType, 0, this);
    }

    public final Credit createCredit(Customer customer, Branch branch, float borrowedAmount, int daysToRepay,
                                             int percent) {
        Date dateForCredit = new Date();
        float amountLeftToPay = borrowedAmount * (100 + percent)/100;
        return new Credit("#" + RandomStringUtils.randomNumeric(5), customer, branch,
                borrowedAmount, amountLeftToPay, daysToRepay, percent, dateForCredit);
    }

    public static float exchangeCurrency(Calculable calcFunc) {
        return calcFunc.calculate();
    }

    @Override
    public void sendMessage() {
        System.out.println("Hello, I am employee");
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
