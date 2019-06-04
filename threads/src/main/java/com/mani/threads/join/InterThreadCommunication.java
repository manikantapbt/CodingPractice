package com.mani.threads.join;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class InterThreadCommunication {

    public static void main(String[] args) {
        SharedQueue q = new SharedQueue();
        FeederThreads f = new FeederThreads(q);
        WorkerThreads w = new WorkerThreads(q);
        w.setPriority(10);
        f.start();
        w.start();
    }
    public static class FeederThreads extends Thread{
        SharedQueue s;
        Random r = new Random();
        FeederThreads(SharedQueue s){
            this.s = s;
        }
        @Override
        public void run(){
            while(true){
                s.add(r.nextInt(5));
            }
        }
    }
    public static class WorkerThreads extends Thread{
        SharedQueue s;
        WorkerThreads(SharedQueue s){
            this.s = s;
        }
        @Override
        public void run(){
            while(true){
                Integer i =s.remove();
                calculateFact(i);
            }
        }
        public void calculateFact(Integer data){
            Integer fact = 1;
            for (int i = 1; i <= data; i++) {
               fact =fact*i;
            }
        }
    }

    public static class SharedQueue {
        Queue<Integer> queue = new ArrayDeque<>();

        public synchronized void add(Integer add){
            queue.add(add);
            notify();
        }

        public synchronized int remove(){
            while(queue.isEmpty()){
                try {
                    wait();
                }catch (InterruptedException e){

                }

            }
            System.out.println("size="+queue.size());

            return queue.remove();

        }

    }
}

