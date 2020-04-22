package ru.ifmo.base.lesson15;


import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User cbf = new User("cbf", "12443", Role.USER);
        User asd = new User("asd", "2625", Role.ADMIN);
        User rty = new User("rty", "8734", Role.USER);
        User bnm = new User("bnm", "2688", Role.ADMIN);

        // Map в java - структура данных, которая хранит данные в виде пары ключ-значение
        // Ключи должны быть уникальными
        // Каждому ключу соответствует только одно значение
        // Map НЕ расширяет интерфейс Collection

        System.out.println("---HashMap---");
        // 1. хранит ключи в hash-таблице (используются hashCode ключей)
        // 2. для объектов,которые используются в качестве ключей должны быть
        // переопределены методы equals и hashCode
        // 3. порядок хранения элементов может отличаться от порядка добавления
        // 4. null может быть использован в качестве ключа

        // создание объекта HashMap
        // в <> первым указывается тип данных ключей - String для данного объекта
        // в <> вторым указывается тип данных значений - User для данного объекта
        HashMap<String, User> userHashMap = new HashMap<>();

        // добавление элементов: в качестве ключей будем использовать логины пользователей,
        // в качестве значений - соответствующие объекты
        userHashMap.put(asd.getLogin(), asd);
        userHashMap.put(cbf.getLogin(), cbf);
        userHashMap.put(rty.getLogin(), rty);
        userHashMap.put(bnm.getLogin(), bnm);
        userHashMap.put(null, null);

        System.out.println(userHashMap);

        // получение значения по ключу, метод вернет значение,
        // которое соответствует данному ключу
        System.out.println(userHashMap.get("asd"));
        // если ключа в мапе не существует, вернет null
        System.out.println(userHashMap.get("fgfddfd"));
        // метод вернет метод вернет значение, которое соответствует данному ключу
        // либо значение по умолчанию (если ключа не существует)
        System.out.println(userHashMap.getOrDefault("vvv", bnm));

        // удаление по ключу: удаляет ключ и связанное с ним значение
        userHashMap.remove("asd");
        // удаление по паре ключ-значение: если указанному ключу соответствует
        // указанное значение, то будут удалены соответствующие ключ и значение
        userHashMap.remove("bnm", bnm);

        // замена по ключу: заменить существующее значение на новое
        // (к ключу null будет привязан объект asd)
        userHashMap.replace(null, asd);
        // замена по паре ключ-значение: если указанному ключу (null)
        // соответствует указанное значение (asd), произойдет заменна на новое
        // значение (null вместо asd)
        userHashMap.replace(null, asd, null);

        System.out.println("---Перебор элементов map---");
        for (Map.Entry<String, User> entry: userHashMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        System.out.println("---EnumMap---");
        // 1. использует enum в качестве ключей, все ключи должны быть одного типа
        // (все они должны быть элементами одного enum)
        // 2. null нельзя использовать в качесве ключа
        // 3. значения (values) хранятся в массиве (размер массива - количество
        // элементов enum)
        // 4. порядок хранения элементов соответствуе порядку элементов в enum
        // 5. для извлечения значений (values) из массива используется
        // порядковый номер ключа - метод ordinal() (vals[key.ordinal()])

        // создание объекта EnumMap, в конструкторе необходимо передать сслыку!!!
        // на enum, который будет использован в качестве ключей
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);








        /*clear
        containsKey
        containsValue
        entrySet
        get
        getOrDefault
        isEmpty
        keySet
        put
        putAll
        putIfAbsent
        remove(2)
        replace(2)
        size
        values*/
        // + конструкторы HashMap, EnumMap, TreeMap












    }
}
