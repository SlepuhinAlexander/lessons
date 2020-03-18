package ru.ifmo.base.lesson7;

abstract public class BattleUnit
        extends Unit
        implements CanAttack {
    protected int attackScore;

    public BattleUnit(int healthScore, int speed, int attackScore) {
        super(healthScore, speed); // вызов конструктора родительского класса
        setAttackScore(attackScore);
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

//    abstract public void attack(BattleUnit enemy);

    public void runFromField(){
        System.out.println("runFromField CanAttack");
    }
}
