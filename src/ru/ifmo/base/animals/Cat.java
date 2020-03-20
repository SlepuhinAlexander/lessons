package ru.ifmo.base.animals;

public class Cat implements CanEat, CanBeEaten {
    @Override
    public void beEat(CanEat enemy) {
        System.out.println("Съеден: " + enemy);
    }


    @Override
    public void eat(CanBeEaten enemy) {
        System.out.println("Съел " + enemy);
    }
}
