package ru.ifmo.base.lesson15;


import java.lang.ref.WeakReference;
import java.sql.Array;
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
        for (Map.Entry<String, User> entry : userHashMap.entrySet()) {
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
        // Role.class - ссылка на enum Role
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);
        enumMap.put(Role.USER, new ArrayList<>(Arrays.asList(cbf, rty)));
        // запись на 83 строке аналогична записям на 85-87 строках:
        // List<User> userList = Arrays.asList(cbf, rty);
        // ArrayList<User> userArrayList = new ArrayList<>(userList);
        // enumMap.put(Role.USER, userArrayList);

        enumMap.put(Role.ADMIN, new ArrayList<>(Arrays.asList(asd, bnm)));

        System.out.println(enumMap);
        System.out.println(enumMap.get(Role.USER));

        // вывести в консоль логины! всех пользователей с ролью ADMIN
        ArrayList<User> users = enumMap.get(Role.ADMIN);
        for (User user : users) {
            System.out.println(user.getLogin());
        }
        User newUser = new User("newUser", "676", Role.ADMIN);
        // добавить объект в enumMap в зависимости от роли
        enumMap.get(newUser.getRole()).add(newUser);
        //newUser.getRole() - получили роль пользователя
        //enumMap.get(newUser.getRole()) - по ключу (роль) получили
            //связанное с ним значение -ArrayList<User>
        //enumMap.get(newUser.getRole()).add(newUser); - в полученный
            //ArrayList добавили объект newUser

        System.out.println("---TreeMap---");
        // 1. хранит элементы в отсортированном по ключам порядке
        // 2. null не может быть использован в качестве ключа
        // 3. класс, объекты которого используются в качестве ключей!!!
        // должен имплементировать интерфейс Comparable
        // либо объект Comparator должен передаваться в констрктор TreeMap
        // 4. основан на алгоритме красно-черного дерева

        userHashMap.remove(null);

        TreeMap<String, User> treeMap = new TreeMap<>(userHashMap);
        System.out.println(treeMap);
        treeMap.put(asd.getLogin(), asd);
        treeMap.put(rty.getLogin(), rty);
        treeMap.put(bnm.getLogin(), bnm);
        System.out.println(treeMap);


        System.out.println("---WeakHashMap---");
        // 1. хранит ключи в hash-таблице
        // 2. для объектов,которые используются в качестве ключей должны быть
        // переопределены методы equals и hashCode
        // 3. порядок хранения элементов может отличаться от порядка добавления
        // 4. null может быть использован в качестве ключа
        // 5. запись из WeakHashMap будет удалена при сборке мусора,
        // если на ключи не осталось сильных ссылок

        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        Object weakKey = new Object();
        String weakVal = "String value";
        weakHashMap.put(weakKey, weakVal);

        HashMap<Object, String> hashMap = new HashMap<>();
        Object hashKey = new Object();
        String hashVal = "String value";
        hashMap.put(hashKey, hashVal);

        // обнуляем ссылки на ключи
        weakKey = null;
        hashKey = null;

        System.gc(); // попытка запустить сборку мусора

        System.out.println("weakHashMap " + weakHashMap);
        System.out.println("hashMap " + hashMap);

        // user - сильная ссылка - strong reference
        User user = new User("user", "34343", Role.ADMIN);
        // weakUser - слабая ссылка - weak reference
        WeakReference<User> weakUser = new WeakReference<>(user);
        user = null;

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
