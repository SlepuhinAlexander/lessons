package ru.ifmo.base.lesson13.garage;

public class BikeGarage extends Garage<Bus> {
    public void checkBike(){
        // getCarOnService() вернет объект типа Bus,
        // тк он указан в BikeGarage extends Garage<Bus>
        System.out.println(this.getCarOnService().isWiFi());
    }
}

class BikeGarage2 extends Garage<Transport> {
    public void checkBike(){
        // getCarOnService() вернет объект типа Transport,
        // тк он указан в BikeGarage2 extends Garage<Transport>
        System.out.println(this.getCarOnService().getNum());
    }
}

class BikeGarage3<T> extends Garage {
    private T manager;
    public void checkBike(){
        // getCarOnService() вернет объект типа Transport,
        // тк он указан в class Garage<T extends Transport & Repairing>
        // если бы в class Garage не было <T extends Transport & Repairing>,
        // а было бы просто class Garage<T>,
        // метод getCarOnService() вернул бы объект типа Object
        System.out.println(this.getCarOnService().getNum());
    }
}
