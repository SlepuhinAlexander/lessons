package ru.ifmo.base.animals;

public class Wolf implements CanEat {

    @Override
    public void eat(CanBeEaten enemy) {
        System.out.println("Съел " + enemy);
    }
}
