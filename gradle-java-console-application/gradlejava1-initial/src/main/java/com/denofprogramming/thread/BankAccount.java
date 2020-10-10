package com.denofprogramming.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(100);

        ExecutorService es = Executors.newFixedThreadPool(5);

        for (int j=0; j<100; j++) {

            Runnable r = () -> {
                for (int i = 0; i < 100; i++) {
                    account.deposit(10);
                    System.out.println("balance is " + account.getBalance() + " in " + Thread.currentThread().getName());
                }
            };
            es.submit(r);
        }
        es.shutdown();

    }
}
