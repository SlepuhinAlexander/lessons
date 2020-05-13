package ru.ifmo.base.lesson22;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamBase {
    public static void main(String[] args) {
         /*Stream API - набор методов для работы с данными, как с потоком
         позволяет представить различные наботы данных в виде потока
         И далее: сортировать их, фильтровать, осуществлять поиск по различным критериям,
         кроме этого позволяет создавать новые потоки, создавать коллекции и мапы на основе потока данных*/
        // Stream НЕ ХРАНИТ ДАННЫЕ Для сохранения данных из Stream нужно использовать специальные методы

         /*Для работы с потоками данных:
         1. получить данные в виде потока - объект типа Stream
         2. выполнить промежуточные операции с потоком данных
         (промежуточные операции обрабатывают данные и возвражают Stream объект)
         3. выполнить терминальную (конечную) операцию
         (терминальная операция обрабатывает данные и завершает работу стрима)
         Без терминальной операции промежуточные операции не начнут выполняться!!!

         Например, получили объект stream
         промежуточные операции
         stream.операция1() - вернет преобразованный объект stream
               .операция2() - вернет преобразованный объект stream
               .операция3()  - вернет преобразованный объект stream
               .терминальнаяОперация(); // запускает промежуточные операции, данные обрабатываются, стрим закрывается
         терминальные forEach / findFirst / findAny / xxxMatch / min / max / collect*/

         /*методы получения Stream объектов:
         из коллекций collection.stream();
         из массива Arrays.stream(arr);
         из файла Files.lines(path_to_file);
         из строки string.chars();
         используя builder:
         Stream.builder().add(obj1).add(obj2).add(objN).build();
         Stream.of(1, 4, 7); любой набор данных*/

        Stream<Integer> integerStream = Stream.of(6, 8, 300, -44, 0, -111, -6);
        // оставит в стрим только те элементы, которые удовлетворяют условию
        integerStream.filter(num -> num < 0) //
                .map(num -> num * 10)
                .limit(2) // оставляет только первые 2 элемента
                .forEach(System.out::println);

        integerStream = Stream.of(45, 67, 45, -500, 0, -500, 120, 45);
        integerStream.distinct()
                .sorted()
                .forEach(System.out::println);

        // терминальные операции:
        // на вход принимают Predicate
        // возвращают true / false
        // anyMatch - хотя - бы один | allMatch - все | noneMatch - ни один
        integerStream = Stream.of(6, 8, 300, -44, 0, -111, -6);
        System.out.println(integerStream.anyMatch(num -> num == 300));

        integerStream = Stream.of(6, 8, 300, -44, 0, -111, -6);
        System.out.println(integerStream.allMatch(num -> num > 0));

        integerStream = Stream.of(6, 8, 300, -44, 0, -111, -6);
        System.out.println(integerStream.noneMatch(num -> num > 5000));

        String[] stringsArr = {"cat", "dog", "pig"};

        // терминальные операции:
        // findFirst - получение первого элемента
        // findAny - получение рандомного элемента
        // возвращают объект типа Optional<T> - null safe container

        // String s = Arrays.stream(stringsArr).skip(3).findFirst().get();
        // get:
        // если элемента нет (null) - NoSuchElementException
        // если элемент есть вернет элемент
        String s = Arrays.stream(stringsArr).findFirst().get();
        System.out.println(s);
        System.out.println(Arrays.stream(stringsArr).findFirst());
        s = Arrays.stream(stringsArr).findFirst().orElse("default");
        // orElse
        // если элемента нет вернет default
        // если элемент есть вернет элемент
        System.out.println(s);
        boolean isElemPresent = Arrays.stream(stringsArr).findFirst().isPresent();

        Arrays.stream(stringsArr)
                .skip(1) // удаляет из стим один первый элемент
                .filter(s1 -> s1.endsWith("g"))
                .forEach(System.out::println);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("qwe", 34));
        users.add(new User("asd", 56));
        users.add(new User("zxc", 18));
        users.add(new User("qwe", 34));
        users.add(new User("zxc", 22));

        // массив пользователей младше 30
        User[] usersArr = users.stream()
                .filter(user -> user.getAge() < 30)
                //.toArray(); Object[]
                .toArray(User[]::new); // User[] u = new User[размер стрима];

        System.out.println(Arrays.toString(usersArr));

        List<User> userList = users.stream()
                .filter(user -> user.getAge() > 30)
                .peek(user -> user.setActive(true))
                .collect(Collectors.toList());

        Set<User> userSet = users.stream()
                .filter(user -> user.getAge() > 20)
                .collect(Collectors.toSet());

        ArrayList<User> userArrayList = users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toCollection(ArrayList::new));

        // терминальные операции:
        // min | max
        // принимают на вход компаратор
        // возвращают объект типа Optional<T>
        User minUser = users.stream()
                .min(Comparator.comparing(User::getAge))
                .orElse(new User("default user", 1));
        System.out.println("min user: " + minUser);

        User maxUser = users.stream()
                .max(Comparator.comparing(User::getAge))
                .orElse(new User("default user", 1000));
        System.out.println("max user: " + maxUser);

        String[] colors = {"red", "red", "black", "orange", "yellow", "green"};
        Map<String, Integer> colorMap = Arrays.stream(colors)
                .collect(Collectors.toMap(
                        Function.identity(), // ключи elem->elem
                        String::length, // значения elem->elem.length()
                        (item1, item2) -> item1
                ));
        HashMap<String, Integer> colorHashMap = Arrays.stream(colors)
                .collect(Collectors.toMap(
                        Function.identity(), // ключи elem->elem
                        String::length, // значения elem->elem.length()
                        (item1, item2) -> item1,
                        HashMap::new
                ));

        List<String> list1 = Arrays.asList("33", "33", "55");
        List<String> list2 = Arrays.asList("111", "34", "11");
        List<String> list3 = Arrays.asList("0", "-33", "55");


        Stream.of(list1, list2, list3)
                // каждый элемент стирима преобразует в новый стим
                // потом собирает в общий
                // distinct() и sorted() отдельно для каждого подстрима
                .flatMap(elem->elem.stream().distinct().sorted())
                .forEach(System.out::println);
        // [list1, list2, list3] стрим из коллекций - строка 155
        // flatMap - строка 159 - каждый элемент в новый подстрим
        //[      обрабатывает элементы каждого подстрима
        //  ["33", "33", "55"].distinct().sorted()
        //  ["111", "34", "11"].distinct().sorted()
        //  ["0", "-33", "55"].distinct().sorted()
        //]
        //[      получает
        //  ["33", "55"]
        //  ["11", "111", "34"]
        //  ["-33", "0", "55"]
        //]
        // собирает в общий стрим
        //["33", "55", "11", "111", "34", "-33", "0", "55"]
        // строка 160 - вывод элементов в консоль

















    }
}
