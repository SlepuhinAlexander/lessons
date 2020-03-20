package ru.ifmo.base.lesson8;

// оператор final с классом запрещает наследование
// от данного класса
public final class CalcUtils {
    // значения final свойств должны быть установлены в момент
    // объявления или в конструкторе
    // значения final свойст нельзя изменить
//    final double PI = 3.14;
    // пишутся в верхнем регистре, каждое последующее слово через _
//    final double PI_VAR;
//    public CalcUtils() {
//        PI_VAR = 3.14;
//    }

    static final double PI;
    // статический блок
    static {
        PI = 3.4;
    }


    public static int summ(int a, int b){
        // из статических методов нельзя обращаться к
        // нестатическим свойствам и методам
        return a + b;
    }




    // final методы нельзя переопределять
    // в дочерних классах
    // final аргументы в методе доступны только для чтения
    public final void someVoid(final int num,
                               final SomeClass sc,
                               final int[] arr){

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
// наследование невозможно, тк CalcUtils
// определен как final class
//class Child extends CalcUtils{
//    @Override
//    public void someVoid() { }
//}

