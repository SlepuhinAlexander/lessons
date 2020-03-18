package ru.ifmo.base.lesson7;

public interface CanAttack {
    void attack(BattleUnit enemy);

    default void runFromField(){
        System.out.println("runFromField CanAttack");
    }
}
