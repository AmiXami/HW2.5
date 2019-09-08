package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        try {

            Semaphore semaphore = new Semaphore(4);
            CountDownLatch countDownLatch = new CountDownLatch(100);
            for (int i = 1; i < 100; i++) {
                new PassengerThread(semaphore, countDownLatch, i).start();
            }
            countDownLatch.await();
            Thread.sleep(100);
            System.out.println("Все пассажири сели на места");
            Thread.sleep(100);
            System.out.println("Отправка в ош");
        }catch (InterruptedException je){
        }
    }
}
