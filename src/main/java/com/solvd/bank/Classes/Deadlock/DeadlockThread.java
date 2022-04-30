package com.solvd.bank.Classes.Deadlock;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.solvd.bank.Classes.Currency;
import org.apache.log4j.Logger;

public class DeadlockThread {
    private static final Logger LOGGER = Logger.getLogger(DeadlockThread.class);

    private static final Currency dollar = new Currency("US Dollar", "USD");
    private static final Currency euro = new Currency("Euro", "EUR");

    public static void test() {
        dollarPriorUser dollarPrior = new dollarPriorUser();
        euroPriorUser euroPrior = new euroPriorUser();
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        tpe.execute(dollarPrior);
        tpe.execute(euroPrior);
        tpe.shutdown();
    }

    private static class dollarPriorUser extends Thread {
        public void run() {
            synchronized (dollar) {
                LOGGER.info("Thread 1: Holding dollar lock");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) { }
                LOGGER.info("Thread 1: Waiting for euro lock");

                synchronized (euro) {
                    LOGGER.info("Thread 1: Holding lock of dollar & euro");
                }
            }
        }
    }
    private static class euroPriorUser extends Thread {
        public void run() {
            synchronized (euro) {
                LOGGER.info("Thread 2: Holding euro lock");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) { }
                LOGGER.info("Thread 2: Waiting for dollar lock");

                synchronized (dollar) {
                    LOGGER.info("Thread 2: Holding lock of euro & dollar");
                }
            }
        }
    }
}
