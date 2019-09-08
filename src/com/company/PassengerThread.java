package com.company;

import javax.swing.plaf.SeparatorUI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class PassengerThread extends Thread {
    Semaphore passeger;
    CountDownLatch pa;
    int id;

    public PassengerThread(Semaphore passeger, CountDownLatch pa, int id) {
        this.passeger = passeger;
        this.pa = pa;
        this.id = id;
    }
    public void run(){
        try{
            synchronized (pa){
            }
            synchronized (passeger){}
            passeger.acquire();
            System.out.println("Человек " + id + " Получил билет");
            sleep(1000);
            passeger.release();
            System.out.println("Человек " + id + " Сел в авто");
            sleep(1000);
            pa.countDown();
        }catch (InterruptedException j){

        }
    }
}

