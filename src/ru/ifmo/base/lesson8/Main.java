package ru.ifmo.base.lesson8;

public class Main {

    public static void main(String[] args) {
        // обращение к статической переменной по имени класса
        System.out.println(CalcUtils.PI);

        // обращение к статическому методу по имени класса
        System.out.println(CalcUtils.summ(3, 5));


        BookHouse bookHouse = new BookHouse("Книжный Дом");
        bookHouse.setDescription("продажа книг");

        BookHouse.showPriceList(); // обращение к статическому методу класса

        bookHouse.showInfo(); // обращение к методу объекта

        bookHouse.soldBook();
        bookHouse.soldBook();
        bookHouse.soldBook();

        bookHouse.showInfo(); // обращение к методу объекта

        BookHouse shop = new BookHouse("Книги");
        shop.setDescription("книги для всех");

        BookHouse.showPriceList(); // обращение к статическому методу класса

        shop.showInfo(); // обращение к методу объекта

        shop.soldBook();
        shop.soldBook();
        shop.soldBook();

        shop.showInfo(); // обращение к методу объекта





    }
}
