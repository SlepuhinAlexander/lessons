package ru.ifmo.base.lesson7;

public class Doctor extends BattleUnit {
    private int medicineScore;

    public Doctor(int healthScore, int speed, int attackScore, int medicineScore) {
        super(healthScore, speed, attackScore);
        setMedicineScore(medicineScore);
    }

    public int getMedicineScore() {
        return medicineScore;
    }

    public void setMedicineScore(int medicineScore) {
        this.medicineScore = medicineScore;
    }

    @Override
    public void attack(BattleUnit unit) {
        System.out.println("Атака доктора");
    }

    @Override
    public void run() {
        System.out.println("Доктор ");
    }

    @Override
    public void rest() {
        System.out.println("Доктор на отдыхе");
    }
}
