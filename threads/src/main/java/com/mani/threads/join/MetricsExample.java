package com.mani.threads.join;


import java.util.Random;

public class MetricsExample {
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);
        BusinessLogic businessLogic1 = new BusinessLogic(metrics);
        BusinessLogic businessLogic2 = new BusinessLogic(metrics);

        metricsPrinter.start();
        businessLogic1.start();
        businessLogic2.start();

    }

    public static class MetricsPrinter extends Thread {
        private Metrics metrics;

        MetricsPrinter(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Average = " + metrics.getAverage());

            }
        }
    }

    public static class BusinessLogic extends Thread {
        private Metrics metrics;
        private Random random = new Random();

        BusinessLogic(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                long startTime = System.currentTimeMillis();
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (Exception e) {

                }
                long end = System.currentTimeMillis() - startTime;
                metrics.addSample(end);
            }
        }
    }

    public static class Metrics {
        private long count = 0;
        private volatile double average = 0.0; // this would guarantee write at line 12 and read at line 16 are atomic

        public synchronized void addSample(long sample) {
            double currentSum = count * average;
            count++;
            average = (currentSum + sample) / count;
        }

        public double getAverage() {
            return average;
        }

    }
}
