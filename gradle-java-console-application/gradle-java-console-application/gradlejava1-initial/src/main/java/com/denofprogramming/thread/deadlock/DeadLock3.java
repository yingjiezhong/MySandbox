package com.denofprogramming.thread.deadlock;

public class DeadLock3 {

        void method1() {
            synchronized(String.class) {
                System.out.println(Thread.currentThread().getName() + " acquired String lock");
                synchronized(Integer.class) {
                    System.out.println(Thread.currentThread().getName() + " acquired Integer lock");
                }
            }
        }

    void method2() {
        synchronized(Integer.class) {
            System.out.println(Thread.currentThread().getName() + " acquired Integer lock");
            synchronized(String.class) {
                System.out.println(Thread.currentThread().getName() + " acquired String lock");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock3 d3 = new DeadLock3();

        Runnable r1 = () -> d3.method1();

        Runnable r2 = () -> d3.method2();

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
