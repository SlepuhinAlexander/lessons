package ru.ifmo.base.cat;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(120,"Downing street", 12);
        Cat cat2 = new Cat(150,"King street", 25);
        cat1.setName("Vasya");
        cat2.setName("Johnny");
        cat1.fightCat(cat2);
        System.out.println(cat1.getHealth());
        cat2.fightCat(cat1);
        System.out.println(cat2.getHealth());
        while (cat1.getHealth() > 0 && cat2.getHealth() > 0){
            cat1.fightCat(cat2);
            cat2.fightCat(cat1);
        }
        if (cat1.getHealth() > 0)   {
            System.out.println(cat1.getName());
        }   else if (cat2.getHealth() > 0) {
            System.out.println(cat2.getName());
        }
        System.out.println(cat2.getHealth());
    }
}
