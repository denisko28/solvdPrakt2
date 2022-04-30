package com.solvd.bank;

import com.solvd.bank.Classes.*;
import com.solvd.bank.Classes.Deadlock.DeadlockRunnable;
import com.solvd.bank.Classes.Deadlock.DeadlockThread;
import com.solvd.bank.Enumerations.AccountType;
import com.solvd.bank.Enumerations.EmployeeType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import com.solvd.bank.Interfaces.IPayCallBack;

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

    static License initLicense() {
        Person licenseSigner = new Person("Polina", "Fedorchuk", "Oleksandrivna");
        Date licenseSignDate = generateDate("13/02/2022");
        Date licenseExpireDate = generateDate("22/12/2025");
        String licenseId = StringUtils.upperCase(RandomStringUtils.randomAlphabetic(2) +
                RandomStringUtils.randomNumeric(5));
        return new License(licenseId, licenseSignDate, licenseExpireDate, licenseSigner);
    }

    static Bank initBank(License license) {
        Address CEOAddress = new Address("57-B", "Stepana bandery", "Lviv",
                "Lviv oblast", "79007", "Ukraine");
        Date CEORegisterDate = generateDate("17/05/2017");
        Employee bankCEO = new Employee(EmployeeType.CEO, CEOAddress, "0986734223", "iamceo@outlook.com",
                CEORegisterDate, "iamceo45", "ceo765123", "George", "Goncharenko",
                "Ruslanovych");

        Date bankAccountDate = generateDate("28/02/2018");
        Account depositAccount = new Account("#0000", bankAccountDate, AccountType.DEPOSIT, 230000, bankCEO);
        Bank bank = new Bank("Privat bank", new ArrayList<Customer>(), new ArrayList<Employee>(),
                new ArrayList<Branch>(), new ArrayList<Transaction>(), new ArrayList<Credit>(),
                new ArrayList<Account>(), depositAccount, license);

        LOGGER.info("\nReflection[");
        Class bankClass = bank.getClass();
        try {
            Method method = bankClass.getDeclaredMethod("addEmployee", Employee.class);
            method.invoke(bank, bankCEO);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
        }
        Field[] bankFields = bankClass.getDeclaredFields();
        for (Field field : bankFields)
            LOGGER.info(field);
        LOGGER.info("\n]");
        // bank.addEmployee(bankCEO);

        return bank;
    }

    static void fillBankCurrencies() {
        Currency dollar = new Currency("US Dollar", "USD");
        HashMap<String, Float> dollarExchange = new HashMap<>();
        dollarExchange.put("EUR", 0.92f);
        dollarExchange.put("GBP", 0.77f);
        dollarExchange.put("CHF", 0.94f);
        dollarExchange.put("CNY", 6.37f);
        dollar.setExchangeValues(dollarExchange);
        Bank.addCurrency(dollar);

        Currency euro = new Currency("Euro", "EUR");
        HashMap<String, Float> euroExchange = new HashMap<>();
        euroExchange.put("USD", 1.08f);
        euroExchange.put("GBP", 0.82f);
        euroExchange.put("CHF", 1.01f);
        euroExchange.put("CNY", 6.88f);
        euro.setExchangeValues(euroExchange);
        Bank.addCurrency(euro);

        Currency pound = new Currency("British Pound", "GBP");
        HashMap<String, Float> poundExchange = new HashMap<>();
        poundExchange.put("USD", 1.30f);
        poundExchange.put("EUR", 1.20f);
        poundExchange.put("CHF", 1.23f);
        poundExchange.put("CNY", 8.32f);
        pound.setExchangeValues(poundExchange);
        Bank.addCurrency(pound);

        Currency frank = new Currency("Swiss Frank", "CHF");
        HashMap<String, Float> frankExchange = new HashMap<>();
        frankExchange.put("USD", 1.06f);
        frankExchange.put("EUR", 0.98f);
        frankExchange.put("GBP", 0.81f);
        frankExchange.put("CNY", 6.75f);
        frank.setExchangeValues(frankExchange);
        Bank.addCurrency(frank);

        Currency yuan = new Currency("Chinese Yuan", "CNY");
        HashMap<String, Float> yuanExchange = new HashMap<>();
        yuanExchange.put("USD", 0.15f);
        yuanExchange.put("EUR", 0.14f);
        yuanExchange.put("GBP", 0.12f);
        yuanExchange.put("CHF", 0.14f);
        yuan.setExchangeValues(yuanExchange);
        Bank.addCurrency(yuan);
    }

    static void testCurrencyExchange() {
        LOGGER.info("333 USD to CNY = " + Bank.exchangeCurrency(333, "USD", "CNY"));

        // With exception
        LOGGER.info("800 USD to CNT = " + Bank.exchangeCurrency(800, "USD", "CNT"));

        LOGGER.info("2350 CHF to USD = " + Bank.exchangeCurrency(2350, "CHF", "USD"));

        LOGGER.info("2758 USD to GBP = " + Bank.exchangeCurrency(2758, "USD", "GBP"));

        LOGGER.info("333 CNY to EUR = " + Bank.exchangeCurrency(196, "CNY", "EUR"));
    }

    static void attachSimpleEmployees(Bank bank) {
        //Employee 1
        Address addressOfSimpleEmployee1 = new Address("78", "Storojinetska", "Chernivtsi",
                "Chernivtsi oblast", "58038", "Ukraine");
        Date dateOfSimpleEmployee1 = generateDate("03/10/2021");
        Employee simpleEmployee1 = new Employee(EmployeeType.SIMPLE_EMPLOYEE, addressOfSimpleEmployee1, "095554568",
                "simple1@gmail.com", dateOfSimpleEmployee1, "simple123", "monkey2021", "Oleg",
                "Voloshyn", "Stepanovych");
        bank.addEmployee(simpleEmployee1);

        //Employee 2
        Address addressOfSimpleEmployee2 = new Address("8-E", "Kaspruka", "Chernivtsi",
                "Chernivtsi oblast", "58034", "Ukraine");
        Date dateOfSimpleEmployee2 = generateDate("12/10/2021");
        Employee simpleEmployee2 = new Employee(EmployeeType.SIMPLE_EMPLOYEE, addressOfSimpleEmployee2, "0501285323",
                "myhajlishina@gmail.com", dateOfSimpleEmployee2, "alex_login", "alex_qwerty2021", "Olexandra",
                "Myhajlishina", "Yriivna");
        bank.addEmployee(simpleEmployee2);
    }

    static void attachBranches(Bank bank) {
        //Branch 1
        Address addressOfBranchHead1 = new Address("12-A", "Holovna", "Chernivtsi",
                "Chernivtsi oblast", "58000", "Ukraine");
        Date dateHeadOfBranch1 = generateDate("01/09/2021");
        Employee headOfBranch1 = new Employee(EmployeeType.BRANCH_HEAD, addressOfBranchHead1, "0955656568",
                "head1@gmail.com", dateHeadOfBranch1, "head123", "pass2021", "Oleksandr",
                "Ivanchenko", "Mykolajovych");
        bank.addEmployee(headOfBranch1);

        ArrayList<Branch> branches = new ArrayList<Branch>();
        Address branch1Address = new Address("113-В", "Prospekt Nezalejnosti", "Chernivtsi",
                "Chernivtsi oblast", "58025", "Ukraine");
        Branch branch1 = new Branch("Branch №1", branch1Address, "0503435433", headOfBranch1);

        bank.addBranch(branch1);
    }

    static void attachCustomers(Bank bank) {
        //Customer 1
        Date registerDateCustomer1 = generateDate("01/02/2022");
        Customer customer1 = new Customer(new ArrayList<>(), new ArrayList<>(), "0504723838",
                "petro33443@gmail.com", registerDateCustomer1, "petryk123", "petro_12345678",
                "Petro", "Filipchuk", "Valentynovych");
        bank.addCustomer(customer1);

        //Customer 2
        Date registerDateCustomer2 = generateDate("05/02/2022");
        Customer customer2 = new Customer(new ArrayList<>(), new ArrayList<>(), "0993938297",
                "olga777@gmail.com", registerDateCustomer2, "olichka1999", "olya_1999",
                "Olga", "Kulko", "Mykolaivna");
        bank.addCustomer(customer2);

        //Customer 3
        Date registerDateCustomer3 = generateDate("19/02/2022");
        Customer customer3 = new Customer(new ArrayList<>(), new ArrayList<>(), "0994593401",
                "mykola262@gmail.com", registerDateCustomer3, "mykola.cool", "mykola_#lopp",
                "Mykola", "Kuzmenko", "Anatolijovych");
        bank.addCustomer(customer3);

        //Customer 4
        Date registerDateCustomer4 = generateDate("28/02/2022");
        Customer customer4 = new Customer(new ArrayList<>(), new ArrayList<>(), "0985566567",
                "nechyporenko@gmail.com", registerDateCustomer4, "IrkaNechyp", "irka188",
                "Iryna", "Nechyporenko", "Ivanivna");
        bank.addCustomer(customer4);
    }

    static void attachAccounts(Bank bank) {
        List<Employee> simpleEmployees = bank.getEmployees().stream()
                .filter(employee -> employee.getEmployeeType() == EmployeeType.SIMPLE_EMPLOYEE)
                .collect(Collectors.toList());
        List<Customer> customers = bank.getCustomers();

        // Customer 1, Account 1
        bank.openAccountForCustomer(simpleEmployees.get(0), customers.get(0), AccountType.SAVINGS,
                (firstN, lastN) -> LOGGER.info("The account 1 was opened for " + firstN + " " + lastN));

        // Customer 1, Account 2
        bank.openAccountForCustomer(simpleEmployees.get(0), customers.get(0), AccountType.EXPENSES,
                (firstN, lastN) -> LOGGER.info("The account 2 was opened for " + firstN + " " + lastN));

        // Customer 2, Account 1
        bank.openAccountForCustomer(simpleEmployees.get(1), customers.get(1), AccountType.EXPENSES,
                (firstN, lastN) -> LOGGER.info("The account 1 was opened for " + firstN + " " + lastN));

        // Customer 3, Account 1
        bank.openAccountForCustomer(simpleEmployees.get(1), customers.get(2), AccountType.EXPENSES,
                (firstN, lastN) -> LOGGER.info("The account 1 was opened for " + firstN + " " + lastN));
    }

    static void topUpAccounts(Bank bank) {
        ArrayList<Account> accounts = bank.getAccounts();

        Account account1 = accounts.get(0);
        Account account2 = accounts.get(1);
        Account account3 = accounts.get(2);

        account1.topUp(4300);
        account2.topUp(235);
        account3.topUp(2460);
    }

    static void attachCredits(Bank bank) {
        List<Employee> employees = bank.getEmployees();
        List<Customer> customers = bank.getCustomers();
        List<Branch> branches = bank.getBranches();

        bank.giveCreditToCustomer(employees.get(1), customers.get(2), branches.get(0),
                customers.get(2).getAccounts().get(0), 2500, 10);
    }

    static void testPayment(Bank bank) {
        List<Customer> customers = bank.getCustomers();

        Customer customer1 = customers.get(0);
        Customer customer2 = customers.get(1);
        Customer customer3 = customers.get(2);

        IPayCallBack payCallBack = transaction -> {
            bank.addTransaction(transaction);
            LOGGER.info("A new payment was done, the transaction: " + transaction.toString());
        };

        customer1.pay(customer1.getAccounts().get(1), customer2.getAccounts().get(0), 340, payCallBack);
        customer2.pay(customer2.getAccounts().get(0), customer3.getAccounts().get(0), 780, payCallBack);
        // Will be thrown an exception, because customer3 doesn't own customer2.account
        customer3.pay(customer2.getAccounts().get(0), customer1.getAccounts().get(0), 20, payCallBack);
        customer3.pay(customer3.getAccounts().get(0), customer1.getAccounts().get(0), 470, payCallBack);
    }

    public static void main(String[] args) {
        License license = initLicense();
        LOGGER.info("Created License with id: '" + license.getId() + "', signed by: '" + license.getSignedBy() + "'");

        Bank bank = initBank(license);
        LOGGER.info("Created Bank with name: '" + bank.getName() + "'");

        LOGGER.info("\nCurrencies exchange test:");
        fillBankCurrencies();
        testCurrencyExchange();

        LOGGER.info("\nAttaching employees to bank:");
        attachSimpleEmployees(bank);
        bank.getEmployees().forEach(employee -> LOGGER.info(employee.toString()));

        LOGGER.info("\nAttaching branches: ");
        attachBranches(bank);
        bank.getBranches().forEach(branch -> LOGGER.info(branch.toString()));

        LOGGER.info("\nAttaching customers: ");
        attachCustomers(bank);
        bank.getCustomers().forEach(customer -> LOGGER.info(customer.toString()));

        LOGGER.info("\nAttaching accounts: ");
        attachAccounts(bank);
        bank.getAccounts().forEach(account -> LOGGER.info(account.toString()));

        LOGGER.info("\nTopping up accounts: ");
        topUpAccounts(bank);
        bank.getAccounts().forEach(account -> LOGGER.info(account.toString()));

        LOGGER.info("\nAttaching credits: ");
        attachCredits(bank);
        bank.getCredits().forEach(credit -> LOGGER.info(credit.toString()));

        LOGGER.info("\nCustomer payment test: ");
        testPayment(bank);

        LOGGER.info("\nBank transactions: ");
        bank.getTransactions().forEach(transaction -> LOGGER.info(transaction.toString()));

        LOGGER.info("\nBank general info: ");
        LOGGER.info(bank.toString());

//        LOGGER.info("\nDeadlock testing: ");
//        DeadlockRunnable.test();
//        DeadlockThread.test();
    }
}
