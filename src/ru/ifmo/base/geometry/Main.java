package ru.ifmo.base.geometry;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        circle1.setRadius(9);
        float per1 = circle1.perimeter();
        float sur1 = circle1.surface();
        System.out.println(per1 + ";  " + sur1);
    }
}
