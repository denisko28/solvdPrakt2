package com.company.Classes;

import java.util.Date;

public class Employee extends User {
    private EmployeeType employeeType;
    private Address address;

    public Employee() {}

    public Employee(
        EmployeeType employeeType,
        Address address,
        String phone,
        String email,
        Date registerDate,
        String login,
        String password,
        String firstName,
        String lastName,
        String patronymic
    ) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeType=" + employeeType.toString() +
                ", address=" + address.toString() +
                super.toString() +
                '}';
    }
}
