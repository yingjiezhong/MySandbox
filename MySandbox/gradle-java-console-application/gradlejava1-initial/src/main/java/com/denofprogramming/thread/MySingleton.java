package com.denofprogramming.thread;

public class MySingleton {

    private static MySingleton instance;

    private MySingleton() {

    }

    public static MySingleton getInstnace() {
        if (instance != null) {
            return instance;
        }

        synchronized (MySingleton.class) {
            if (instance == null) {
                instance = new MySingleton();
            }
            return instance;
        }
    }
}
