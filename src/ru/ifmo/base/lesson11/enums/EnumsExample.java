package ru.ifmo.base.lesson11.enums;

import java.util.Arrays;

public class EnumsExample {
    public static void main(String[] args) {
        // Создать класс Article со следующими полями:
        // title - название статьи
        // text - текст статьи
        // dateCreated - дата и время написания статьи (текущие дата и время должны устанавливаться
        // во время создания объекта)
        // значение title инициализируется при создании объекта,
        // text - через сеттер

        // создание объекта типа Article
        Article article = new Article("Путешествие по Австралии");
        article.setText("Текст статьи");
        // обращение к элементу enum НазваниеПеречисления.ЭЛЕМЕНТ
        article.setCountry(Country.AUSTRALIA);
        System.out.println(article);

        Article ukArticle = new Article("Путешествие по Великобритании");
        ukArticle.setText("Текст статьи");
        // обращение к элементу enum НазваниеПеречисления.ЭЛЕМЕНТ
        ukArticle.setCountry(Country.UK);
        System.out.println(ukArticle);

        // методы enum
        // получение массива констант values()
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));

        // индекс элемента enum в массиве
        System.out.println(Country.UK.ordinal());

        for (Country country: countries){
            System.out.println("country: " + country.name() + " - " + country.ordinal());
        }

        // получение элемента enum по строке
        // IllegalArgumentException, если элемент не найден
        System.out.println(Country.valueOf("USA"));

        // enum Priority
        int codeHigh = Priority.HIGH.getCode(); // вызов метода у елемента enum
        System.out.println("codeHigh = " + codeHigh);

        Priority low = Priority.LOW;
        low.setCode(123);

        Priority low2 = Priority.LOW;
        System.out.println(low2.getCode()); // 123

        Operation operation = Operation.MULTI;
        System.out.println(operation.action(2, 6));

        operation = Operation.SUM;
        System.out.println(operation.action(2, 6));

    }
}

// enum - перечисление - набор логически связанных констант
// объявление перечисления: enum НазваниеПеречиления {
//  элементы через запятую.
// Если в enum только элементы, точку с запятой после последнего можно не ставить
// }
enum Country {
    UK, USA, AUSTRALIA // элементы enum - объекты типа Country
}

// enum может создаваться с дополнительными свойсвами,
// конструкторами и методами

enum Priority {
    HIGH(10), MIDDLE(5), LOW(1);
    private int code;

    Priority(int code) {
        this.code = code;
    }

    public int getCode() { // метод доступен всем элементам
        return code;
    }

    public void setCode(int code) { // метод доступен всем элементам
        this.code = code;
    }
}

// каждый элемент enum может иметь свою реализацию общего метода

enum Operation{
    SUM {
        @Override
        public int action(int a, int b) { // реализация метода элемента SUM
            return a + b;
        }
    },
    MULTI {
        @Override
        public int action(int a, int b) { // реализация метода элемента MULTI
            return a * b;
        }
    };

    public abstract int action(int a, int b);// общий метод
}







