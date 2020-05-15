package ru.ifmo.base.multithreading.lesson23;

public class Threads {
    public static void main(String[] args) {
        // Жизненный цикл потока:
        // 1. создание потока (создание объекта) NEW
        // 2. поток готов к работе (вызов метода start)
        // 3. поток запущен
        // 4. non-runnable (TIME WAITING / WAITING / BLOCKED) - поток находится в состоянии ожидания
        // 5. TERMINATED - поток завершил работу

        // Варианты описания потоков и их инструкций
        // 1. создание класса, который наследуется от класса Thread
        // 2. создание класса (с инструкциями для потока),
        // который имплементирует интерфейс Runnable
        // 3. реализация run интерфейса Runnable (инструкции потока) описать
        // через лямбда выражение

        // первый вариант - создание класса, который наследуется от класса Thread
        // создание объекта
        FirstThread firstThread = new FirstThread(); // Thread-0
        System.out.println(firstThread.getName() + ": " + firstThread.getState());
        firstThread.start(); // вызов метода start - не равен вызову метода run
        // вызов метода start говорит о том, что поток готов к работе и
        // будет запущен шедулером jvm

        // второй вариант - создание класса (с инструкциями для потока),
        // который имплементирует интерфейс Runnable
        // создание объекта
        // объект thread не является потоком!
        // SecondThread thread = new SecondThread();
        Thread secondThread = new Thread(new SecondThread()); // Thread-1
        secondThread.start();

        // третий вариант - реализация run интерфейса Runnable (инструкции потока) описать
        //  через лямбда выражение
        Thread thirdThread = new Thread(()->{ // Thread-2
            System.out.println("thirdThread isAlive " +
                    Thread.currentThread().isAlive());
        });
        thirdThread.start();

        Thread threadOne = new Thread(new SecondThread()); // Thread-3
        Thread threadTwo = new Thread(new SecondThread()); // Thread-4
        Thread threadThree = new Thread(new SecondThread()); // Thread-5

        System.out.println("Группа потоков, которой принадлежит threadOne: " +
                threadOne.getThreadGroup());
        System.out.println("Максимальный приоритет группы " +
                threadOne.getThreadGroup().getMaxPriority());
        // установка приоритета носит РЕКОМЕНДАТЕЛЬНЫЙ характер
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.setPriority(1); // IllegalArgumentException
        threadTwo.setPriority(5);
        threadThree.setPriority(10);
        System.out.println("Приоритет threadOne: " + threadOne.getPriority());

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        // нам нужно, чтобы основной поток ждал, пока завершатся потоки
        // threadOne / threadTwo / threadThree
        // join - вызывающий (в данном случае main) поток ожидает,
        // когда к нему присоединятся (завершат выполнение) указанные потоки
        // (в данном случае threadOne / threadTwo / threadThree)

        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Основной поток " + Thread.currentThread().getName());

        // Поток останавливается если:
        // 1. выполнил все инструкции
        // 2. было выброшено необработанное исключение
        // 3. остановилась jvm
        // 4. поток был daemon потоком и все не daemon потоки завершили свою работу

        FirstThread daemon = new FirstThread();
        // поток завершает работу, когда все не daemon потоки завершат работу
        daemon.setDaemon(true);

        // [main daemon(while true)]
        // [main thread(while true)]

        // interrupt = true;
        Thread actions = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("some actions...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
            System.out.println("After While");
        });
        actions.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.interrupt();

    }
}
// первый вариант - создание класса, который наследуется от класса Thread
class FirstThread extends Thread{

    @Override
    public void run(){ // инструкции потока
        // когда метод run будет вызван
        // инструкции начнут выполняться в отдельном потоке
        // (не вызывать из кода!!! + не путать с методом start())
        Thread.currentThread().setName("First Thread");
        System.out.println(Thread.currentThread().getName() + ": " +
                Thread.currentThread().getState());
    }
}
// второй вариант - создание класса (с инструкциями для потока),
// который имплементирует интерфейс Runnable
class SecondThread implements Runnable {

    @Override
    public void run() { // инструкции потока
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}