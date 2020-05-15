package ru.ifmo.base.multithreading.lesson23;

public class Threads {
    public static void main(String[] args) {
        // Варианты описания потоков и их инструкций
        // 1. создание класса, который наследуется от класса Thread


        System.out.println("Основной поток " + Thread.currentThread().getName());
    }
}
// первый вариант - создание класса, который наследуется от класса Thread
class FirstThread extends Thread{

    @Override
    public void run(){ // инструкции потока
        // когда метод run будет вызван
        // инструкции начнут выполняться в отдельном потоке
        // ()

    }

}