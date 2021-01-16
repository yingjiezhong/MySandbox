package com.denofprogramming.thread.deadlock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadLock2Test {

    @Test
    void main() throws InterruptedException {

        DeadLock2.Person p = new DeadLock2.Person();

        Runnable r1 = () -> {
           p.method1();
        };

        Runnable r2 = () -> {
            p.method2();
        };

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();

        System.out.println("main exit");

    }
}