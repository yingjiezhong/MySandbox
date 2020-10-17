package com.denofprogramming.thread.deadlock;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DynamicOrderDeadlock2Test {
    @Test
    void transferMoney() throws InterruptedException {
        final int THREADS = 20;
        final int ACCOUNTS = 5;
        final int TRANSACTIONS = 1000;

        final Random rnd = new Random();
        final DynamicOrderDeadlock2.Account[] accounts = new DynamicOrderDeadlock2.Account[ACCOUNTS];
        final Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < ACCOUNTS; i++) {
            accounts[i] = new DynamicOrderDeadlock2.Account();
        }

        for (int j = 0; j < THREADS; j++) {

            Runnable r = () -> {
                for (int i = 0; i < TRANSACTIONS; i++) {
                    int from = rnd.nextInt(5);
                    int to = rnd.nextInt(5);
                    int amount = rnd.nextInt(500);
                    if (from != to) {
                        try {
                            DynamicOrderDeadlock2.transferMoney(accounts[from], accounts[to], new DynamicOrderDeadlock2.DollarAmount(500), 100);
                        } catch (DynamicOrderDeadlock2.InsufficientFundsException e) {
//                            e.printStackTrace();
                        }
                    }
                    if (i%100 == 0) {
                        System.out.println("Transaction " + i + " --- " + Thread.currentThread().getName());
                    }
                }

            };
            threads[j] = new Thread(r);
            threads[j].start();
        }

        for (int i = 0; i < THREADS; i++) {
            threads[i].join();
        }

        int sum = 0;
        for (int i = 0; i < ACCOUNTS; i++) {
            System.out.println("account " + i + ": " + accounts[i].getBalance().value());
            sum += accounts[i].getBalance().value();

        }
        System.out.println("Sum: " + sum);


        System.out.println("completed");

    }
}