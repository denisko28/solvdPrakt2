package com.solvd.bank;

import com.solvd.bank.Classes.*;
import com.solvd.bank.Enumerations.AccountType;
import com.solvd.bank.Enumerations.EmployeeType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

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

        Address CEOAddress = new Address("57-Б", "Степана бандери", "Львів",
                "Львівська область", "79007", "Україна");
        Date CEORegisterDate = generateDate("17/05/2017");
        Employee bankCEO = new Employee(EmployeeType.CEO, CEOAddress, "0986734223", "iamceo@outlook.com",
                CEORegisterDate, "iamceo45", "ceo765123", "Георгій", "Гончаренко",
                "Русланович");

        Date bankAccountDate = generateDate("28/02/2018");
        Account depositAccount = new Account("#0000", bankAccountDate, AccountType.DEPOSIT, 230000, bankCEO);
        Bank bank = new Bank("Приват банк", new ArrayList<Customer>(), new ArrayList<Employee>(),
                new ArrayList<Branch>(), new ArrayList<Transaction>(), new ArrayList<Service>(), new ArrayList<Credit>(),
                new ArrayList<Account>(), depositAccount, license);

        bank.addEmployee(bankCEO);

        //Employees
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Address addressOfBranchHead = new Address("12-A", "Головна", "Чернівці",
                "Чернівецька область", "58000", "Україна");
        Date dateHeadOfBranch1 = generateDate("01/09/2021");
        Employee headOfBranch1 = new Employee(EmployeeType.BranchHead, addressOfBranchHead, "0955656568",
                "head1@gmail.com", dateHeadOfBranch1, "head123", "pass2021", "Олександр",
                "Іваненко", "Миколайович");

        Address addressOfSimpleEmployee1 = new Address("78", "Сторожинецька", "Чернівці",
                "Чернівецька область", "58038", "Україна");
        Date dateOfSimpleEmployee1 = generateDate("03/10/2021");
        Employee simpleEmployee1 = new Employee(EmployeeType.SimpleEmployee, addressOfSimpleEmployee1, "095554568",
                "simple1@gmail.com", dateHeadOfBranch1, "simple123", "monkey2021", "Олег",
                "Волошин", "Степанович");

        bank.addEmployee(headOfBranch1);
        bank.addEmployee(simpleEmployee1);

        //Branches
        ArrayList<Branch> branches = new ArrayList<Branch>();
        Address branch1Address = new Address("113-В", "Проспект незалежності", "Чернівці",
                "Чернівецька область", "58025", "Україна");
        Branch branch1 = new Branch("Відділення №1", branch1Address, "0503435433", headOfBranch1);

        bank.addBranch(branch1);

        //Customers
        Date registerDateCustomer1 = generateDate("01/02/2022");
        Customer customer1 = new Customer(new ArrayList<Account>(), new ArrayList<Credit>(), "0504723838",
                "petro@gmail.com", registerDateCustomer1, "petryk123", "petro_12345678",
                "Петро", "Філіпчук", "Валентинович");

        bank.addCustomer(customer1);

        //Accounts
        bank.openAccountForCustomer(simpleEmployee1, customer1, AccountType.SAVINGS);
        bank.openAccountForCustomer(simpleEmployee1, customer1, AccountType.EXPENSES);


        //Credits
        Date dateForCredit1 = generateDate("03/08/2022");
        Credit credit1 = new Credit("#00001", customer1, branch1, 2500, 2500,
                10, 5, dateForCredit1);

        customer1.addCredit(credit1);
        bank.addCredit(credit1);

        //Output
        LOGGER.info(bank.toString());
    }
}
