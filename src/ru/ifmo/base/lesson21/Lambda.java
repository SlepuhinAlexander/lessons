package ru.ifmo.base.lesson21;

public class Lambda {
    private Operation plus = (n, m) -> n + m;
    private static Operation staticPlus = (n, m) -> n + m;

    public Operation getPlus() {
        return plus;
    }

    public void setPlus(Operation plus) {
        this.plus = plus;
    }

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

        System.out.println(Calculator.calculate(3, 67, plus));
        System.out.println(Calculator.calculate(100, 50, division));

        // лямбда без созранения в переменную
        System.out.println(Calculator.calculate(10, 10, (a, b) -> a - b));

    }
}

// функциональный - интерфейс с одним абстранктным методом!
// и любым количеством default методов
@FunctionalInterface
interface Operation {
    double execute(double a, double b);
}


class Calculator {
    public static double calculate(double a, double b, Operation operation) {
        return operation.execute(a, b);
    }
}