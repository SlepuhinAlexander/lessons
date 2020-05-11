package ru.ifmo.base.lesson21;

public class Lambda {
    public static void main(String[] args) {
        // лямбда - реализация метода интерфейса
        // при этом в интерфейсе должен быть только один
        // абстрактный метод! и любое количество default методов

        // реализация метода с сохранением в переменную
        // Operation operation = реализация метода через лямбда;
        /*
         принимаемые аргументы:
         1 можно не заключать в () один аргумент
         2 во всех остальных случаях () должны быть!
         3 можно не указыть тип данных аргументов -
         тип данных агруменотов берется из контекста метода
         интерфейса*/
         /*тело (реализация метода):
         1 если реализация метода состоит из одной инструкции и
         предполагается возвращать значение,
         то {} указывать не нужно + return по умолчанию
         2 если реализация метода состоит из нескольких
         инструкций {} обязательны
         (метод по умолчанию ничего не возвращает)
         при необходимости вернуть результат необходимо
         написать return*/
        Operation plus = (n, m) -> n + m;
        Operation division = (a, b) -> {
            if (b == 0) throw new IllegalArgumentException("0!!!");
            return a / b;
        };
        System.out.println(plus.execute(34, 134));

    }
}

// функциональный - интерфейс с одним абстранктным методом
// и любым количеством default методов
@FunctionalInterface
interface Operation {
    double execute(double a, double b);
}


class Calculator {
    public static double calculate(double a, double b, Operation operation){
        return operation.execute(a, b);
    }
}