package com.denofprogramming.thread.deadlock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.denofprogramming.thread.deadlock.DynamicOrderDeadlock.*;

import static org.junit.jupiter.api.Assertions.*;

class DynamicOrderDeadlockTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void transferMoney() throws InterruptedException {
        final int THREADS = 10;
        final int ACCOUNTS = 5;
        final int TRANSACTIONS = 1000;

        final Random rnd = new Random();
        final Account[] accounts = new Account[ACCOUNTS];
        final Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < ACCOUNTS; i++) {
            accounts[i] = new Account();
        }

        for (int j = 0; j < THREADS; j++) {

            Runnable r = () -> {
                for (int i = 0; i < TRANSACTIONS; i++) {
                    int from = rnd.nextInt(5);
                    int to = rnd.nextInt(5);
                    int amount = rnd.nextInt(500);
                    if (from != to) {
                        try {
                            DynamicOrderDeadlock.transferMoney(accounts[from], accounts[to], new DollarAmount(500));
                        } catch (InsufficientFundsException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Transaction " + i + " --- " + Thread.currentThread().getName());
                }

            };
            threads[j] = new Thread(r);
            threads[j].start();
        }

        for (int i = 0; i < THREADS; i++) {
            threads[i].join();
        }

        System.out.println("completed");

    }
}