package ru.ifmo.base.lesson16.reflection;


public class ReflectionExample {

//    static {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
//    }

    public static void main(String[] args)  {
        // Рефлексия в Java — это механизм, с помощью которого можно получать информацию
        // о классах, интерфейсах, полях и методах
        // во время выполнения программы, для чего нужна только ссылка на класс.
        // Кроме того, Reflection API дает возможность создавать новые экземпляры классов,
        // вызывать методы, а также получать или устанавливать значения полей.

        // Все классы в языке являются объектами типа Class

        // получение ссылок на класс
        Class strClass = String.class; // ссылка на класс String
        System.out.println(strClass);
        Class intClass = int.class; // ссылка на int
        System.out.println(intClass);
        Class textMessageClass = TextMessage.class; // ссылка на класс TextMessage
        System.out.println(textMessageClass);





    }
}
