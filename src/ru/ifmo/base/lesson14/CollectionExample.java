package ru.ifmo.base.lesson14;


import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Алексеев", 18);
        Student student2 = new Student("Екатерина", "Еремина", 20);
        Student student3 = new Student("Денис", "Попов", 22);
        Student student4 = new Student("Петр", "Попов", 22);

        // в java существует несколько реализаций коллекций (все они имплементирую интерфейс Collection) и различаются:
        // безопасностью использования в многопоточых срадах,
        // возможностью хранить дублирующиеся элементы,
        // возможностью хранить элементы в отсортированным виде,
        // скоростью добавления, удаления, извлечения элементов из начала / середины / конца коллекции
        // возможностью хранить элементы в том порядке, в котором они были добавлены и тд

        // Коллекции, которые необходимы для работы в многопоточных средах мы рассмотрим в теме по многопоточности.
        // Все коллекции, которые будут рассмотрены в lesson14 не являются потокобезопасными

        // все коллекции - дженерики, при создании объекта коллекции
        // в <> необходимо указать объекты какого типа Вы собираетесь в ней
        // хранить

        System.out.println("---List---");
        System.out.println("---LinkedList---");
        // двунаправленный связный список
        // Особенности LinkedList:
        // 1. элементы хранятся в порядке добавления
        // 2. можно хранить null
        // 3. допускает хранения дублирующихся элементов

        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.add(student1); // добавление элемента в конец списка
        studentLinkedList.add(student2); // добавление элемента в конец списка
        studentLinkedList.add(student1); // добавление элемента в конец списка

        // добавление элемента на указанную позицию (индекс первого
        // элемента - 0)
        studentLinkedList.add(1, student3);
        // при обращении к несуществующему индексу:
        // IndexOutOfBoundsException
//        studentLinkedList.add(10, student3);

        studentLinkedList.addFirst(null); // добавление элемента
        // в начало списка

        System.out.println(studentLinkedList);

        // для каждого элемента коллекции будет вызван метод
        // System.out.println()
        studentLinkedList.forEach(System.out::println);

        System.out.println(studentLinkedList.getLast()); // вернет последний
        System.out.println(studentLinkedList.getFirst()); // вернет 1й
        System.out.println(studentLinkedList.get(2)); // вернет элемент,
        // находящий на указанной позиции

        studentLinkedList.removeFirst(); // удаление первого элемента
        studentLinkedList.removeLast(); // удаление последнего элемента
        studentLinkedList.remove(1); // удаление элемента по индексу
        studentLinkedList.remove(student1); // удаляет переданный
        // элемент из списка
        studentLinkedList.remove(); // == removeFirst();

        System.out.println("после удаления " + studentLinkedList);

        System.out.println("---ArrayList---");
        // динамически расширяемый массив
        // Особенности ArrayList:
        // 1. реализован на основе массива
        // 2. порядок хранения элементов соответствуе порядку добавления
        // 3. можно хранить null
        // 4. допускает хранения дублирующихся элементов

        // внутри ArrayList по умолчанию создается массив на 10 элементов
        ArrayList<Student> studentArrayList = new ArrayList<>();
        // можно указать изначальный размер ArrayList
        studentArrayList = new ArrayList<>(20);
        System.out.println(studentArrayList.size()); // количество элементов
        // коллекции

        studentArrayList.add(student1); // добавление в конец ArrayList
        studentArrayList.add(student2); // добавление в конец ArrayList
        studentArrayList.add(1, null); // добавление
        // на указанную позицию

        System.out.println(studentArrayList.size()); // 3

        studentArrayList.trimToSize(); // урезает внутренний массив
        // до количества элементов ArrayList

        // можно получить часть списка, указав [начальную;конечную) позиции
        System.out.println("sublist " + studentArrayList.subList(0, 1));

        System.out.println(studentArrayList.get(0)); // получение по индексу

        studentArrayList.remove(student1);
        studentArrayList.remove(1);
//        studentArrayList.removeAll(удаляемая коллекция);

        Student[] studentsArray = {student1, student2, student3};
        List<Student> arrAsList = Arrays.asList(studentsArray); // возвращает список
        studentArrayList.addAll(arrAsList); // на вход необходимо передать
        // коллекцию - Collection

        System.out.println("---Интерфейс Set---");
        // Особенности Set:
        // 1. позволяет хранить только уникальные элементы
        // 2. обязательно должны быть переопределены методы
        // equals и hashCode

        System.out.println("---HashSet---");
        // Особенности HashSet:
        // 1. основан на hash таблице (использует hashCode)
        // 2. порядок хранения элементов может отличаться
        // от порядка добавления
        // 3. может хранить null (всегда на 1м месте)

        HashSet<Student> studentHashSet = new HashSet<>(arrAsList);
        System.out.println("studentHashSet " + studentHashSet);

        System.out.println("---LinkedHashSet---");
        // Особенности LinkedHashSet:
        // 1. разница с HashSet:
        // порядок хранения элементов не отличается от порядка добавления
        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(student1);
        linkedHashSet.add(student2);
        linkedHashSet.add(null);
        System.out.println("linkedHashSet " + linkedHashSet);

        System.out.println("---TreeSet---");
        // Особенности TreeSet:
        // 1. не позволяет добавить null
        // 2. элементы хранит в отсортированном порядке
        // 3. основан на алгоритме красно-черного дерева
        // 4. необходимо задать порядок сортировки

        // Для добавления элементов в TreeSet необходимо:
        // 1. чтобы класс (экземпляры которого будут храниться в
        // данной коллекции) реализовывал интерфейс Comparable
        // в его метод compareTo (в нем определяется, какой объект считать
        // большим, какой меньшим)
        // 2. пердать в конструктор TreeSet компаратор - объект класса
        // Comparator

        // класс реализует интерфейс Comparable
        TreeSet<Student> treeSet1 = new TreeSet<>();
        treeSet1.add(student1);
        treeSet1.add(student2);
        treeSet1.add(student3);
        System.out.println("treeSet1 " + treeSet1);

        // пердать в конструктор TreeSet компаратор - объект класса Comparator
        // сначала сортировка по имени, если имена одинаковые - по возрасту
        Comparator<Student> studentComparator = new StudentNameComparator()
                .thenComparing(new StudentAgeComparator());

        TreeSet<Student> treeSet2 = new TreeSet<>(studentComparator);
        treeSet2.add(student1);
        treeSet2.add(student2);
        treeSet2.add(student3);
        System.out.println("treeSet2 " + treeSet2);











    }
}
