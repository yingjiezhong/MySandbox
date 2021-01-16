package com.denofprogramming.thread;

public class PrintNumberThread {

    static Object lock = new Object();

    public static void solution() throws InterruptedException {

        Runnable r1 = () -> {
            int i = 0;

            while (i <= 100) {
                synchronized (lock) {
                    try {
                        if (i != 0) {
                            System.out.println("even - waiting");
                            lock.wait();
                        }
                        System.out.println(i);
                        i = i + 2;
                        Thread.sleep(200);
                        lock.notifyAll();
                        System.out.println("even - notifying");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable r2 = () -> {
            int i = 1;

            while (i < 100) {
                synchronized (lock) {
                    try {
                        System.out.println("odd - waiting");
                        lock.wait();
                        System.out.println(i);
                        i = i + 2;
                        Thread.sleep(200);
                        lock.notifyAll();
                        System.out.println("odd - notifying");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread(r2);
        t2.start();

        Thread.currentThread().sleep(2000);

        Thread t1 = new Thread(r1);
        t1.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main exit");


    }

    public static void main(String[] argv) throws InterruptedException {
        PrintNumberThread.solution();
    }
}
