package ru.ifmo.base.lesson16.reflection;


import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionExample {

    static {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
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

        // получение ссылок на класс через объект
        TextMessage textMessage = new TextMessage("Срочное сообщение");
        textMessage.setText("Рефлексия");

        textMessageClass = textMessage.getClass(); // ссылка на класс TextMessage
        System.out.println(textMessageClass);

        // получим название класса, название пакета
        String className = textMessageClass.getName();
        //  .getPackageName()
        String packageName = textMessageClass.getPackage().getName();
        System.out.println(className);
        System.out.println(packageName);

        // интерфейсы, которые имплементирует класс
        // getInterfaces - возвращает только интерфейсы самого класса
        Class[] interfaces = textMessageClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        // получим ссылку на родительский класс
        Class parent = textMessageClass.getSuperclass();
        System.out.println(parent); // Message

        parent = textMessageClass.getSuperclass().getSuperclass(); // Object
        System.out.println(parent); // Object

        parent = textMessageClass.getSuperclass().getSuperclass().getSuperclass();
        System.out.println(parent); // null

        Class[] parentInterfaces = textMessageClass
                .getSuperclass().getInterfaces();
        System.out.println(Arrays.toString(parentInterfaces));

        // доступ к компонентам класса
        Class<TextMessage> tmClass = TextMessage.class;
        // доступ к полям (свойствам) класса
        // import java.lang.reflect.Field;
        // getFields возвращает все публичные! поля класса,
        // включая родительские
        Field[] fields = tmClass.getFields();
        System.out.println(Arrays.toString(fields));

        // getDeclaredFields возвращает все поля текущего класса!,
        // с любым модификатором (исключая родительские)
        Field[] declaredFields = tmClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // доступ к методам
        // import java.lang.reflect.Method;
        // getMethods возвращает все публичные! методы класса,
        // включая родительские
        Method[] methods = tmClass.getMethods();
        System.out.println(Arrays.toString(methods));

        // getDeclaredMethods возвращает все методы текущего класса!,
        // с любым модификатором (исключая родительские)
        Method[] declaredMethods = tmClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        // доступ к констркторам
        Constructor[] constructors = tmClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));

        // создание объекта с использованием рефлексии

        // получим конструктор (для этого необходимо знать
        // тип данных и последовательность аргументов)
        Constructor<TextMessage> tmConstructor =
                tmClass.getDeclaredConstructor(String.class);
        // создадим объект, используя полученные конструктор
        TextMessage reflectMessage =
                tmConstructor.newInstance("Рефлексивный объект");
        System.out.println(reflectMessage);

        // получим ссылку на поле private String text
        // по названию поля - text
        Field field = tmClass.getDeclaredField("text");
        System.out.println(field.getName());
        System.out.println(field.getType());
        field.setAccessible(true);
        // получили значение поля text объекта reflectMessage
        System.out.println(field.get(reflectMessage));
        // установка значения поля для объекта
        field.set(reflectMessage, "значение установлено через рефлексию");
        // получили значение поля text объекта reflectMessage
        System.out.println(field.get(reflectMessage));
        System.out.println(reflectMessage.getText());

        // получим доступ к методу
        Method method = tmClass
                .getDeclaredMethod("printText", String.class, String.class);
        // вызов метода объекта
        method.setAccessible(true);
        // вызов метода у объекта
        method.invoke(reflectMessage, "!!!", "###");

        BigTextMessage bmt = new BigTextMessage("Big Message");
        field.set(bmt, "Big text");
        System.out.println("bmt " + field.get(bmt));


        boolean isPrivate = Modifier.isPrivate(field.getModifiers());
        System.out.println("is text private " + isPrivate);



    }
}
