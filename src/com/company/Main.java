package com.company;

import com.company.Classes.*;
import com.company.Enumerations.AccountType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    static Date generateDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        }catch (ParseException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        //Bank
        Person licenseSigner = new Person("Поліна", "Федорчук", "Олександрівна");
        Date licenseSignDate = generateDate("13/02/2022");
        Date licenseExpireDate = generateDate("22/12/2025");
        License license = new License("AH1643", licenseSignDate, licenseExpireDate, licenseSigner);

        Date bankAccountDate = generateDate("28/02/2018");
        Account depositAccount = new Account("#0000", bankAccountDate, AccountType.DEPOSIT, 230000);
        Bank bank = new Bank("Приват банк", new ArrayList<Customer>(), new ArrayList<Employee>(), new ArrayList<Branch>(),
                new ArrayList<Transaction>(), new ArrayList<Service>(), new ArrayList<Credit>(), depositAccount, license);

        //Employees
        ArrayList<Employee> employees = new ArrayList<Employee>();
        EmployeeType employeeTypeHead = new EmployeeType("Директор відділення", "Керує відділенням");
        Address addressOfBranchHead = new Address("12-A", "Головнв", "Чернівці",
                "Чернівецька область", "58000", "Україна");
        Date dateHeadOfBranch1 = generateDate("01/09/2021");
        Employee headOfBranch1 = new Employee(employeeTypeHead, addressOfBranchHead, "0955656568",
                "head@gmail.com", dateHeadOfBranch1, "head123", "pass2021", "Олександр",
                "Іваненко", "Миколайович");

        employees.add(headOfBranch1);

        //Branches
        ArrayList<Branch> branches = new ArrayList<Branch>();
        Address branch1Address = new Address("113-В", "Проспект незалежності", "Чернівці",
                "Чернівецька область", "58025", "Україна");
        Branch branch1 = new Branch("Відділення №1", branch1Address, "0503435433", headOfBranch1);

        branches.add(branch1);

        //Accounts
        ArrayList<Account> accountsOfCustomer1 = new ArrayList<Account>();

        AccountType accountSavingsType = AccountType.SAVINGS;
        AccountType accountExpensesType = AccountType.EXPENSES;

        Account account1 = new Account("#3456", new Date(), accountSavingsType, 5000);
        Date dateForAccount2 = generateDate("12/02/2022");
        Account account2 = new Account("#4456", dateForAccount2, accountExpensesType, 12000);

        accountsOfCustomer1.add(account1);
        accountsOfCustomer1.add(account2);

        //Customers
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Date registerDateCustomer1 = generateDate("01/02/2020");
        Customer customer1 = new Customer(accountsOfCustomer1, new ArrayList<Credit>(), "0504723838",
                "petro@gmail.com", registerDateCustomer1, "petryk123", "petro_12345678",
                "Петро", "Філіпчук", "Валентинович");

        customers.add(customer1);

        //Credits
        Date dateForCredit1 = generateDate("03/06/2021");
        Credit credit1 = new Credit("#00001", customer1, branch1, 2500, 2500,
                10, 5, dateForCredit1);

        customer1.addCredit(credit1);
        bank.addCredit(credit1);


        //Output
        System.out.println(bank.toString());
    }
}
