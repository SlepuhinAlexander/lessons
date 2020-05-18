package ru.ifmo.base.multithreading.lesson24.sync;

public class YieldV {
    public static void main(String[] args) {
        new Thread(new PrintThread()).start();
        new Thread(new PrintThread()).start();
    }
}

class PrintThread implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Имя потока: " + Thread.currentThread().getName());
            Thread.yield();
        }
    }
}
