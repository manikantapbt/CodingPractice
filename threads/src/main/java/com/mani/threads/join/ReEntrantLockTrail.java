package com.mani.threads.join;

public class ReEntrantLockTrail {

    public static void main(String[] args) {
        SharedResource s= new SharedResource();

        Thread t = new Thread(() ->
        {
            while (true) {
                s.methodA();
            }
        }
        );
        Thread t1 = new Thread(() ->
        {
            while (true) {
                s.methodB();
            }
        }
        );
        t.start();
        t1.start();
    }
    private static class SharedResource{
        private synchronized void methodA(){
            System.out.println("methodA "+Thread.currentThread().getId());
            methodB();
        }

        private synchronized void methodB(){
            System.out.println("methodB "+Thread.currentThread().getId());
        }

        private synchronized void methodc(){
            System.out.println("methodB "+Thread.currentThread().getId());
            methodB();
        }

    }
}
