package com.denofprogramming.thread.racecondition;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccount {

    private int balance;
    private static int numOfThreads = 1000;
    private Object lock = new Object();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    public void deposit(int amount) {
        synchronized (lock) {
            balance += amount;
        }
    }

    public static void raceCondition1() {
        BankAccount account = new BankAccount(0);

        ExecutorService es = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numOfThreads);
        for (int j=0; j<numOfThreads; j++) {

            Runnable r = () -> {
                for (int i = 0; i < 1000; i++) {
                    account.deposit(1);
//                    System.out.println("balance is " + account.getBalance() + " in " + Thread.currentThread().getName());
                }
                latch.countDown();
//                System.out.println("latch: " + latch.toString());
            };
            es.submit(r);
//            System.out.println("submit task: " + j);
        }

        try {
            latch.await();
            System.out.println("latch counted down");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        es.shutdown();

        System.out.println("balance: " + account.getBalance());


    }

    public static void raceCondition2() {
        BankAccount account = new BankAccount(0);

        Thread[] ts = new Thread[numOfThreads];

        for (int j=0; j<numOfThreads; j++) {

            Runnable r = () -> {
                for (int i = 0; i < 1000; i++) {
                    account.deposit(1);
//                    System.out.println("balance is " + account.getBalance() + " in " + Thread.currentThread().getName());
                }
            };

            ts[j] = new Thread(r);
            ts[j].start();
        }

        for (Thread t : ts ) {
            try {
                t.join();
//                System.out.println("join");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("balance: " + account.getBalance());

    }

    public static void main(String[] args) {
        raceCondition2();

    }
}
