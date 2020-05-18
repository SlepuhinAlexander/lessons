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

        for (IncrementThread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("counter: " + counter.getCounter());

        // counter: counter=2

        // [t1 counter=1] [t2 counter=1] [t3 counter=1]
        // [t1 counter=2] [t2 counter=2] [t3 counter=2]



    }
}

class Counter {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

//    public void increment(){
    public synchronized void increment(){
        counter++;
    }
}

class IncrementThread extends Thread{
    private final Counter counter;

    public IncrementThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
//            synchronized (counter){
                counter.increment();
                // поток отпустит объект после завершения
                // всех инструкций в synchronized блоке
//            }
        }
    }
}