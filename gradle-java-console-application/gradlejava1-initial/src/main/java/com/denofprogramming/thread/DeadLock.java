package com.denofprogramming.thread;

public class DeadLock {

    static private class Person {

        // remove the static declaration of locks, it has no deadlock
        static private Object lock1 = new Object();
        static private Object lock3 = new Object();

        void method1() {
            synchronized(lock1) {
                System.out.println(Thread.currentThread().getName() + " running in method 1");
                System.out.println(Thread.currentThread().getName() + " holds lock 1: " + Thread.holdsLock(lock1));

                method3();
            }
        }

        void method2() {
            synchronized(lock1) {
                System.out.println(Thread.currentThread().getName() + " running in method 2");
                System.out.println(Thread.currentThread().getName() + " holds lock 1: " + Thread.holdsLock(lock1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        void method3() {
            synchronized(lock3) {
                System.out.println(Thread.currentThread().getName() + " running in method 3");
                System.out.println(Thread.currentThread().getName() + " holds lock 3: " + Thread.holdsLock(lock3));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                method2();
            }
        }

    }

    public static void main(String[] args) {
        Person alice = new Person();
        Person bob = new Person();

        Runnable r1 = () -> {
            alice.method1();
        };

        Runnable r2 = () -> {
            bob.method3();
        };

        Thread t1 = new Thread(r1);
        t1.setName("ALICE");
        Thread t2 = new Thread(r2);
        t2.setName("BOB");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
