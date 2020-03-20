package ru.ifmo.base.animals;

public class Mouse implements CanBeEaten {
    @Override
    public void beEat(CanEat enemy) {
        System.out.println("Съеден: "+ enemy);
    }
    public  void fnc(){
        System.out.println("Бесполезная строка");
    }
}
