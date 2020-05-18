package ru.ifmo.base.multithreading.lesson24.sync;


import java.util.ArrayList;

public class Synchronized {
    public static void main(String[] args) {
        Counter counter = new Counter();

        ArrayList<IncrementThread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new IncrementThread(counter));
        }

        for (IncrementThread thread: threads){
            thread.start();
        }



    }
}

class Counter {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void increment(){
        counter++;
    }
}

class IncrementThread extends Thread{
    private Counter counter;

    public IncrementThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}