package ru.ifmo.base.lesson8;

public class BookHouse {

    // статическое свойство
    private static int soldBookCounterStatic;

    private final String PRINTING_HOUSE;

    private int soldBookCounterNonStatic;
    private String description;

    public BookHouse(String title) {
        PRINTING_HOUSE = title;
    }

    public void setDescription(final String description) {
//        description = "Нельзя изменить final аргументы";
        this.description = description; // final аргументы доступны только для чтения
    }

    public void soldBook(){
        soldBookCounterNonStatic++;
        soldBookCounterStatic++;
        System.out.println("Книга продана");
    }

    final public void showInfo(){
        System.out.println("soldBookCounter = " + soldBookCounterNonStatic);
        System.out.println("soldBookCounterStatic = " + soldBookCounterStatic);
    }

    // статическией метод
    public static void showPriceList(){
        System.out.println("Книги до 500 страниц - 1000p." + "Книги более 500 страниц - 2000р.");
    }

}
