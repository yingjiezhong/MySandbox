package com.denofprogramming.thread.deadlock;

public class DeadLock2 {

    static class Person {
        private Object lock1 = new Object();
        private Object lock2 = new Object();

        void method1() {
            synchronized(lock1) {
                System.out.println(Thread.currentThread().getName() + " running in method 1");
                System.out.println(Thread.currentThread().getName() + " holds lock 1: " + Thread.holdsLock(lock1));
                method2();
            }
        }

        void method2() {
            synchronized(lock2) {
                System.out.println(Thread.currentThread().getName() + " running in method 2");
                System.out.println(Thread.currentThread().getName() + " holds lock 2: " + Thread.holdsLock(lock2));
                method3();
            }
        }

        void method3() {
            synchronized(lock1) {
                System.out.println(Thread.currentThread().getName() + " running in method 3");
                System.out.println(Thread.currentThread().getName() + " holds lock 1: " + Thread.holdsLock(lock1));
            }
        }

    }

    public static void main(String[] args) {
        Person alice = new Person();

        Runnable r1 = () -> alice.method1();

        Runnable r2 = () -> alice.method2();

        Thread t1 = new Thread(r1);
        t1.setName("T1");
        Thread t2 = new Thread(r2);
        t2.setName("T2");

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
