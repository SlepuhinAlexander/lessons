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
    // knight / doctor / infantry
    public static BattleUnit getBattleUnit(String type) {
        BattleUnit battleUnit = null;
//    healthScore (от 2 до 12),speed (от 1 до 8),attackScore (от 1 до 9),horseSpeed (от 3 до 16)
        if ("knight".equals(type)) {
            battleUnit = new Knight((int) (Math.random() * 10 + 2), (int) (Math.random() * 7 + 1), (int) (Math.random() * 8 + 1), (int) (Math.random() * 13 + 3));
        } else if ("doctor".equals(type)) {
            battleUnit = new Doctor((int) (Math.random() * 10 + 2), (int) (Math.random() * 7 + 1), (int) (Math.random() * 8 + 1), (int) (Math.random() * 13 + 3));
        } else if ("infantry".equals(type)) {
            battleUnit = new Infantry((int) (Math.random() * 10 + 2), (int) (Math.random() * 7 + 1), (int) (Math.random() * 8 + 1), (int) (Math.random() * 13 + 3));
        }
//        if ("knight".equals(type)) {
//            return new Knight((int) (Math.random() * 10 + 2), (int) (Math.random() * 7 + 1), (int) (Math.random() * 8 + 1), (int) (Math.random() * 13 + 3));
//        }
//        if ("doctor".equals(type)) {
//            return new Doctor((int) (Math.random() * 10 + 2), (int) (Math.random() * 7 + 1), (int) (Math.random() * 8 + 1), (int) (Math.random() * 13 + 3));
//        }
//        if ("infantry".equals(type)) {
//            return new Infantry((int) (Math.random() * 10 + 2), (int) (Math.random() * 7 + 1), (int) (Math.random() * 8 + 1), (int) (Math.random() * 13 + 3));
//        }
        return battleUnit;
    }
}
