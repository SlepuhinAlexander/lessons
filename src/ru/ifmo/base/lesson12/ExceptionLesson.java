package ru.ifmo.base.lesson12;

import ru.ifmo.base.lesson11.gc.Message;

import java.io.IOException;

public class ExceptionLesson {
    public static void main(String[] args) {
        // исключения и ошибки - это объекты
        /*Error - ошибки, связанные с проблемами уровня JVM. Например,
        нехватка heap памяти или stack памяти
        Ошибки (все Error) не следует обрабатывать в программе.*/

        /*Exception - исключения. Все исключения можно предугадать и обработать.
        Некоторые из них мы обязаны обработать в программе.*/

         /*Все исключения делятся на:
         1. Исключения времени выполнения (наследники RuntimeException) /
         unchecked / необрабатываемые / неотслеживаемые / неконтролируемые.
         Исключения данного типа можно обрабатывать в программе, а можно и
         не обрабатывать
         2. Все остальные исключения: checked / исключения времени компиляции /
         обрабатываемые / отслеживаемые / контролируемые.
         Исключения данного типы мы обязаны! обработать в программе*/


         // некоторые RuntimeException
        int a = 12;
        int b = 0;
        int res;
        // res = a / b; // RuntimeException - ArithmeticException

        int[] arr = new int[3]; // создали массив на 3 элемента
//        arr[89] = 12; // RuntimeException ArrayIndexOutOfBoundsException

        String string = null;
//        string.equals("hello"); // RuntimeException NullPointerException

        Object someData = "253"; // нельзя обработать как строчку
        // (доступны только методы Object)
        Integer someInteger;
//        someInteger = (Integer) someData; // RuntimeException ClassCastException

        // обработка исключений (checked и unchecked)
        // для обработки исключений используется try catch блок и блок finally

        try { // в блок try помещается потенциально опасный участок кода,
            // код, который может привести к Exception
            System.out.println("before a / b");
            res = a / b; // когда в блоке try происходит ArithmeticException
            // усправление переходит в блок catch, остальной код в try
            // выполнен не будет
            System.out.println("after a / b");
        } catch (ArithmeticException e){ // перехватывает тот Exception,
            // который указан в ()
            // ArithmeticException - тип данных исключения
            // e - имя переменной (в нее попадет объект исклучения из блока try)

            // перечисляем инструкции, которые должны быть выполнены,
            // при ArithmeticException
            System.out.println(e.getMessage()); // сообщение с информацией об исключении
            e.printStackTrace(); // stack trace
            res = 1000;
        }
        System.out.println("after try catch");
        System.out.println("res = " + res);

        // объединение catch блоков, если нам нужно обработать несколько исключений
        // 1 вариант (несколько блоков catch): позволяет обработать разные
        // типы исключений разными способами
        try {
            if (System.currentTimeMillis() % 2 == 0) someInteger = (Integer)someData;
            else arr[77] = 100;
        } catch (ClassCastException e) { // перехватерает ClassCastException и
            // всех его потомков
            System.out.println("Проблема с приведением типов");
        } catch (ArrayIndexOutOfBoundsException e) {
            // перехватерает ArrayIndexOutOfBoundsException и
            // всех его потомков
            System.out.println("Проблема с массивом");
        }

        // 2 вариант: все исключения обрабатываются одиноковым способом
        try {
            if (System.currentTimeMillis() % 2 == 0) someInteger = (Integer)someData;
            else arr[77] = 100;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e){
            // перехватывает ClassCastException и всех его потомков +
            // перехватывает ArrayIndexOutOfBoundsException и всех его потомков
            System.out.println("Проблема с массивом или приведением типов");
            System.out.println(e.getMessage());
        }

        // 3 вариант: через общего родителя (через общий тип данных)
        try {
            if (System.currentTimeMillis() % 2 == 0) someInteger = (Integer)someData;
            else arr[77] = 100;
        } catch (RuntimeException e) {
            // перехватывает RuntimeException и всех его потомков
            System.out.println("Проблема с чем-то в RuntimeException");
            System.out.println(e.getMessage());
        }



        try {
            if (System.currentTimeMillis() % 2 == 0) someInteger = (Integer)someData;
            else arr[77] = 100;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            // перехватывает ClassCastException и всех его потомков +
            // перехватывает ArrayIndexOutOfBoundsException и всех его потомков
            System.out.println("Проблема с массивом или приведением типов");
        } catch (RuntimeException e) {
            // перехватывает RuntimeException и всех его потомков, кроме
            // ClassCastException и ArrayIndexOutOfBoundsException (они будут
            // обработаны в первом catch)
            System.out.println("Проблема с чем-то в RuntimeException");
            System.out.println(e.getMessage());
        }

        // блок finally (не обязательный блок)
        finally {
            // код, который написан в блоке finally выполнится в случае любого
            // исключения, даже если оно не перехватывается в блоке catch
            // или если исключение не произошло
            // используется для закрытия ресурсов
            // не должен содержать необработанных исключений
            System.out.println("finally");
        }

        // в языке есть возможность не только обрабатывать,
        // но и генерировать исключения
        // метод выбрасывает RuntimeException, поэтму мы можем обработать его,
        // поместив вызом метода в блок try, а можем не обрабатывать. Тогда
        // в случае исключения программа прекратит выполнение
        voidWithUncheckedException(40);
        voidWithUncheckedException(100);

        try {
            // метод генерирует обрабатываемое исключение, поэтому мы обязаны
            // обработать его в блоке try - catch или пробросить на уревень выше
            voidWithCheckedException("asd.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SomeMessage someMessage = null;
        String title = ""; // данные приходят от пользователя
        String text = "Текст"; // данные приходят от пользователя
        try {
            someMessage = new SomeMessage(title, text);
        } catch (ChatException e) {
            // допустим наши действи в блоке try привели к выбросу исключения
            try {
                // допустим при возникновении исключения в блоке try нам нужно
                // выбросить еще одно исключение
                throw new ChatException("some data").initCause(e);
            } catch (Throwable ex) {
                System.out.println("Throwable " + ex.getCause());
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        // если объект не создан, следующий код приведет
        // к NullPointerException (значит необходимо вернуться к проверке
        // входящих данных)
        System.out.println(someMessage.getText());


    }

    private static void voidWithCheckedException(String s) throws IOException{
        if (s.endsWith("txt")) {
            // генерируем и выбрасываем обрабатываемое исключение
            throw new IOException("Проблема с файлом");
        }
        System.out.println("s = " + s);
    }

    private static void voidWithUncheckedException(int a){
        if (a < 15) {
            // генерируем и выбрасываем runtime исключение
            throw new IllegalArgumentException("Значение не должно быть меньше 15");
        }
        System.out.println("a = " + a);
    }

}

