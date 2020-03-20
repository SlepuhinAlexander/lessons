package ru.ifmo.base.lesson7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // вызов статических методов осуществляется по имени класса

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите тип первого юнита");
        BattleUnit unit1 =
                BattleUnit.getBattleUnit(scanner.nextLine());

        System.out.println("Введите тип второго юнита");
        BattleUnit unit2 =
                BattleUnit.getBattleUnit(scanner.nextLine());

        unit1.attack(unit2);


    }
}
