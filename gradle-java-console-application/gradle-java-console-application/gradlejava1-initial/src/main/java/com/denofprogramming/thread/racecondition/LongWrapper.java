package com.denofprogramming.thread.racecondition;

public class LongWrapper {
    private volatile long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        return l;
    }

    public synchronized void incrementValue() {
        l += 1;
    }

    public static void main (String[] args) {
        LongWrapper longWrapper = new LongWrapper(0L);

        Thread[] ts = new Thread[100];

        for (int j=0; j<ts.length; j++) {

            Runnable r = () -> {
                for (int i = 0; i < 1000; i++) {
                    longWrapper.incrementValue();
//                    System.out.println("balance is " + longWrapper.getValue() + " in " + Thread.currentThread().getName());
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

        System.out.println("Value: " + longWrapper.getValue());

    }
}
