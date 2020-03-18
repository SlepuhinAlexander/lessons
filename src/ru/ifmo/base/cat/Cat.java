package ru.ifmo.base.cat;

public class Cat {
    String name;
    int weight;
    int age;
    String colour;
    String ownerAddress;
    int health;
    int power;

    public Cat(String name, String colour)  {
        setName(name);
        setColour(colour);
    }

    public Cat(int health, String ownerAddress, int power)  {
        setHealth(health);
        setOwnerAddress(ownerAddress);
        setPower(power);
    }

    public Cat()    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.length() > 3 ) {
            this.name = name;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void printInfo() {
        System.out.println("Имя кота: " + getName());
    }

    public void fightCat(Cat enemyCat)  {
        health -= enemyCat.getPower();
    }


}
