package ru.ifmo.base.lesson8;

// оператор final с классом запрещает наследование от данного класса
public final class CalcUtils {
    // значения final свойств должны быть установлены в момент объявления или в конструкторе
    // значения final свойст нельзя изменить
    // пишутся в верхнем регистре, каждое последующее слово через _

//    final String TITLE = "Класс Utils";
    private final String TITLE;

    public CalcUtils() {
        TITLE = "Класс Utils";
    }

    static final double PI;
    // статический блок (используется для инициализации статических свойств)
    static {
        PI = 3.4;
    }


    public static int summ(int a, int b){
        // из статических методов нельзя обращаться к нестатическим свойствам и методам
        // доступ к someVoid запрещен
        return a + b;
    }




    // final методы нельзя переопределять в дочерних классах
    // final аргументы в методе доступны только для чтения
    public final void someVoid(final int num, final SomeClass sc, final int[] arr){

//        final int a = 6;
        System.out.println(num);
//        num = 90;
        System.out.println(sc);
        System.out.println(sc.name);
        sc.name = "Новое имя";
//        sc = new SomeClass();
        arr[4] = 34;

    }
}

class SomeClass {
    String name;
}
// наследование невозможно, тк CalcUtils  определен как final class
//class Child extends CalcUtils{ }

