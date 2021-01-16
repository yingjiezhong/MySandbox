package com.denofprogramming.thread.deadlock;

import java.util.Random;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * DynamicOrderDeadlock2
 * <p/>
 * Dynamic lock-ordering deadlock
 *
 * @author Brian Goetz and Tim Peierls
 */
public class DynamicOrderDeadlock2 {
    // Warning: deadlock-prone!
    public static void transferMoney(Account fromAccount,
                                     Account toAccount,
                                     DollarAmount amount,
                                     long timeout)
            throws InsufficientFundsException {

        Random rnd = new Random();


        while (true) {
            int v = rnd.nextInt(100);
            if (fromAccount.getLock().tryLock()) {
                try {
                    if (toAccount.getLock().tryLock()) {
                        try {
                            if (fromAccount.getBalance().compareTo(amount) < 0)
                                throw new InsufficientFundsException();
                            else {
                                fromAccount.debit(amount);
                                toAccount.credit(amount);
                            }
                        } finally {
                            toAccount.getLock().unlock();
                        }
                    }
                } finally {
                    fromAccount.getLock().unlock();
                }
            }

            try {
                Thread.sleep(timeout+v);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class DollarAmount implements Comparable<DollarAmount> {
        // Needs implementation
        int amount;

        public DollarAmount(int amount) {
            this.amount = amount;
        }

        public DollarAmount add(DollarAmount d) {
            return new DollarAmount(amount + d.value());
        }

        public DollarAmount subtract(DollarAmount d) {
            return new DollarAmount(amount - d.value());
        }

        public int compareTo(DollarAmount dollarAmount) {
            return this.value() - dollarAmount.value();
        }

        public int value() {
            return amount;
        }
    }

    static class Account {
        private DollarAmount balance;
        private final int acctNo;
        private static final AtomicInteger sequence = new AtomicInteger();
        private Lock lock = new ReentrantLock();

        Lock getLock() {
            return lock;
        }

        public Account() {
            acctNo = sequence.incrementAndGet();
            balance = new DollarAmount(500);
        }

        void debit(DollarAmount d) {
            balance = balance.subtract(d);
        }

        void credit(DollarAmount d) {
            balance = balance.add(d);
        }

        DollarAmount getBalance() {
            return balance;
        }

        int getAcctNo() {
            return acctNo;
        }
    }

    static class InsufficientFundsException extends Exception {
    }
}