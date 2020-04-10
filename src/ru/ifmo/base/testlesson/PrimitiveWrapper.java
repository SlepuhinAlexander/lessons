package ru.ifmo.base.testlesson;

public class PrimitiveWrapper {
    public static void main(String[] args) {
        // Примитивные типы данных:
        // byte | short | int | long | float | double | boolean | char

        // для каждого примитива существует класс-обертка
        // byte - class Byte
        // short - class Short
        // int - class Integer
        // long - class Long
        // float - class Float
        // double - class Double
        // char - class Character
        // boolean - class Boolean

        // примитивы нужно использовать всегда, за исключением случаев:
        // 1. когда использование примитивов невозможно
        // 2. когда необходимо воспользоваться методами классов-оберток

        int count = 267; // создали переменную типа int
//        Integer age = new Integer(200); // данный вариант не используется
        // принято использовать вариант:
        Integer age = 200; // создали объект типа Integer

        // автоупаковка и автораспаковка
        // автоупаковка - переменной класса-обертки присваивается значение примитива
        Integer num = 12; // = count;

        // автораспаковка - когда переменной примитивного типаприсваивается значение
        // обертки
        double price;
        Double someDouble = 45.12;
        price = someDouble; // автораспаковка

        // Некоторые правила автоупаковки и автораспаковки
//        1. автоупаковка не работает если примитив не соответствует
//        типу  классу обертки
        // Byte byteObj = 300; автоупаковка не работает
        byte one = 1;
//        num = one; автоупаковка не работает
//        num = (Integer) one; автоупаковка не работает
        num = (int) one; // атоупаковка  работает



        // на автораспаковку данное правило не распротроняется
        Byte two = 2;
        int num2 = two;

        Integer a = 23;
        Byte b = 12;
//        b = (Byte) a;
//        a = (Integer) b;

        // 2. параметры методов подлежат правилам автоупаковки и автораспаковки
        // создать приватный статический метод, который принимает на вход
        // число типа Integer и выводит в консоль значение этого элемента
        // в квадрате

        int c = 4;
        PrimitiveWrapper.sgr(c);

        // 3. автоупаковка и автораспаковка не работают с массивами
        // создать приватный статический метод, который принамает на вход
        // массив типа Double[] double и в цикле выводит в консоль
        // каждый его элемент

        double[] doubles = {3.56, 78.12, 66.9, -34.8};
//        printDoubleArr(doubles); // автоупаковка не работает

        // Некоторые методы оберток над примитивами
        // методы, возвращающие byte, int, long, double и тд
        // методы возвращают примитивы!
//        num.byteValue();
//        num.floatValue();
//        num.doubleValue();
//        num.longValue();
//        num.intValue();

        // методы преобразования строки с числом к числу
        // метод parseXXX(строка с числом); возвращают примитв
        // метод valueOf(строка с числом); возвращают объект

        System.out.println(Byte.parseByte("2")); // byte
        System.out.println(Byte.valueOf("2")); // объект типа Byte

        System.out.println(Integer.parseInt("34")); // int
        System.out.println(Integer.valueOf("34")); // объект типа Integer

        // если строка содержит не только число, то мы получим
        // NumberFormatException
//        System.out.println(Integer.valueOf("3 vo gtwh "));

        System.out.println(Double.valueOf("2.7"));
//        System.out.println(Double.valueOf("4,6"));

        // аналогично для Long, Float, Short

//        Integer.hashCode(45); // 45
//        Integer.hashCode(34); // 34

        // сравнение целочисленных значений (например, Integer):
        // значения в диапазоне [-128; 127]
        Long first = 45L;
        Long second = 45L;
//        сравнение через ==
        System.out.println("45 == 45: " + (first == second)); // true

        // значения вне диапазона [-128; 127]
        Long fourth = 155L;
        Long fifth = 155L;
//        сравнение через ==
        System.out.println("155 == 155: " + (fourth == fifth));

        Integer someInt = 12;
        Integer someInt2 = 12;

        System.out.println(someInt.compareTo(someInt2)); // 0
        System.out.println(Integer.compare(someInt, someInt2)); // 0

        System.out.println(fourth.equals(fifth)); // true

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.TYPE);





    }

    private static void printDoubleArr(Double[] doubles) {
        for (Double d : doubles) {
            System.out.print(" " + d);
        }
    }

    private static void fnc1(Double[] mass) {
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
    }

        private static void sgr (Integer num){
            System.out.println(num * num);
        }

        private static void sqr (Integer input){
            Integer squar = input * input;
            System.out.println(squar);
        }

        private static void fnc (Integer x){
            System.out.println(x *= x);
        }


    }
