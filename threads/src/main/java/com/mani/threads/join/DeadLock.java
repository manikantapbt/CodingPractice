package com.mani.threads.join;

public class DeadLock {
    public static void main(String[] args) {
        SharedResource s = new SharedResource();

        Thread t = new Thread(() ->
        {
            while (true) {
                s.sharedRes();
            }
        }
        );
        Thread t1 = new Thread(() ->
        {
            while (true) {
                s.sharedRes1();
            }
        }
        );
        t.start();
        t1.start();
    }

    public static class SharedResource {
        Object lock1 = new Object();
        Object lock2 = new Object();

        public void sharedRes() {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }

        public void sharedRes1() {
            synchronized (lock2) {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }
    }
}

