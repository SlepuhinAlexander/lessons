package ru.ifmo.base.lesson13;

public class GenericExample {
    public static void main(String[] args) {
        // в <> указываем конкретный типа данных, который будет подставляться вместо T
        User<String> stringUser = new User<>(); // тип данных id объекта stringUser - String
        stringUser.setId("twrt867fur76");
        stringUser.setLogin("qwe");
        stringUser.setPwd("123");

        // в generic нельзя использовать примитивы (только соответствующие классы - обертки)
        User<Integer> integerUser = new User<>();// тип данных id объекта stringUser - Integer
        integerUser.setId(14);
        integerUser.setLogin("fgh");
        integerUser.setPwd("1111");

        System.out.println(stringUser);
        System.out.println(integerUser);

        // для объекта container1 тип данных key - String
        // для объекта container1 тип данных value - Integer
        PairContainer<String, Integer> container1 = new PairContainer<>("qwe", 12);

        // для объекта container2 тип данных key - Double
        // для объекта container2 тип данных value - User с любым типом поля id
        PairContainer<Double, User> container2 = new PairContainer<>(3.3, stringUser);
        // в мосент выполнения программы тип данных поля id для User не определен,
        // и он станет стипом Object
        container2.getValue().setId(12); // id - Object
        container2.getValue().setId("asd"); // id - Object

        // для объекта container3 тип данных key - Double
        // для объекта container3 тип данных value - User с типом поля id - String
        PairContainer<Double, User<String>> container3 = new PairContainer<>(4.6, stringUser);
        container3.getValue().setId("rtyry456454");  // id - String

        User<Number> numberUser = new User<>();
        numberUser.setId(44);
        // для объекта container4 тип данных key - Double
        // для объекта container4 тип данных value - User с типом поля id - Number и только Number!!!
        PairContainer<String, User<Number>> container4 = new PairContainer<>("hello", numberUser);








    }
}
