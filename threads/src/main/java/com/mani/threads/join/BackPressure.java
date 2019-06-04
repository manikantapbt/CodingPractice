package com.mani.threads.join;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class BackPressure {
    static int max_queue=1;
    public static void main(String[] args) {

        SharedQueue q = new SharedQueue();
        FeederThreads f = new FeederThreads(q);
        WorkerThreads w = new WorkerThreads(q);
        f.start();
        w.start();

    }

    public static class FeederThreads extends Thread {
        SharedQueue s;
        Random r = new Random();

        FeederThreads(SharedQueue s) {
            this.s = s;
        }

        @Override
        public void run() {
            while (true) {
                s.add(r.nextInt(5));
            }
        }
    }

    public static class WorkerThreads extends Thread {
        SharedQueue s;

        WorkerThreads(SharedQueue s) {
            this.s = s;
        }

        @Override
        public void run() {
            while (true) {
                Integer i = s.remove();
                calculateFact(i);
            }
        }

        public void calculateFact(Integer data) {
            Integer fact = 1;
            for (int i = 1; i <= data; i++) {
                fact = fact * i;
            }
        }
    }

    public static class SharedQueue {
        Queue<Integer> queue = new ArrayDeque<>();

        public synchronized void add(Integer add){
            if(queue.size()==max_queue){
                try {
                    wait();
                }catch (InterruptedException e){

                }
            }
            queue.add(add);
            notify();
        }

        public synchronized int remove(){
            if(queue.isEmpty()){
                try {
                    wait();
                }catch (InterruptedException e){

                }
            }

            System.out.println("size="+queue.size());
            int i = queue.remove();
            if(queue.size()!=max_queue){
                notify();
            }
            return  i;
        }

//        public synchronized void add(Integer add) {
//            if(queue.size()==max_queue){
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            queue.add(add);
//
//            notify();
//        }

//        public synchronized Integer remove() {
//            if (queue.isEmpty()) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                }
//            }
//
//            System.out.println("size=" + queue.size());
//            if(queue.size()==max_queue-1){
//                notify();
//            }
//            return queue.remove();
//        }
    }
}

