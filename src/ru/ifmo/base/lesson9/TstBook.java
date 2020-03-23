package ru.ifmo.base.lesson9;

public class TstBook {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Object - родительский класс для всех
        // java классов, соответственно его
        // методы доступны для использования и
        // переопределения в дочерних классах

        Object obj = new Object();
        // методы класса Object
        // 1. toString() - возвращает строковое
        // представление объекта
        Author author = new Author();
        author.setName("Иван");
        author.setSurName("Григорьев");

        ChildBook book1 =
                new ChildBook(new String[] {"dog", "cat"});
        book1.setTitle("Детская книга");
        book1.setPageCount(230);
        book1.setAuthor(author);

        String stringBook = book1.toString();
        System.out.println(stringBook);

        // 2. equals(Object other) - используется
        // для сравнения объектов
        // 3. hashCode() - возвращает hash code объекта

        ChildBook book2 =
                new ChildBook(new String[] {"dog", "cat"});
        book2.setTitle("книга");
        book2.setPageCount(230);
        book2.setAuthor(author);

        boolean equalsBooks = book1.equals(book2);
        System.out.println(equalsBooks);

        System.out.println(book1.hashCode());

        // 4. clone() - для создания копии объекта
//        ChildBook cloneBook = book1; // ссылки на 1 объект

        ChildBook cloneBook = book1.clone();
        // Вариант 1 - использование базовой реализации:
        // класс должен реализовать интерфейс Cloneable
        // можно расширить модификатор доступа до public
        // в методе выполнить приведение типов,
        // например (ChildBook) super.clone();
        // и изменить тип возвращаемого значения
        // public ChildBook clone()

        // Вариант 2- без использование базовой реализации:
        // класс не обязан реализовать интерфейс Cloneable
        // необходимо написать свою реализацию по созданию
        // копии объекта

        System.out.println(cloneBook.clone());




    }
}
