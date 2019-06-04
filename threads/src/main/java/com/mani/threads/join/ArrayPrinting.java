package com.mani.threads.join;

import java.util.ArrayList;

public class ArrayPrinting {
    public static void main(String[] args) {
        ArrayToBePrinted a = new ArrayToBePrinted();
        Thread even = new Thread(()->{
            while(!a.reachedEnd){
                a.printEven();
            }
        });
        Thread odd = new Thread(()->{
            while(!a.reachedEnd){
                a.printOdd();
            }
        });

        even.start();
        odd.start();
    }
}

 class ArrayToBePrinted{
    int[] arr = {1,2,3,4,5,6,7,8,9};
    boolean isEven=true;
    int index=0;
    boolean reachedEnd=false;
    public synchronized void printEven(){

        while (!isEven){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getId()+" "+ arr[index++]);
        isEven=false;
        if(index==arr.length){
            reachedEnd=true;
        }
        notifyAll();
    }
    public synchronized void printOdd(){
        while (isEven){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getId()+" "+ arr[index++]);
        isEven=true;
        if(index==arr.length){
            reachedEnd=true;
        }
        notifyAll();
    }
}

