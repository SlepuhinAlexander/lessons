package ru.ifmo.base.lesson13.garage;

public class TstGarage {
    public static void main(String[] args) {
        Bus bus = new Bus("Спб", "Тверь", "234", false);
        Train train = new Train("Спб", "Москва", "23-Ф", 12);

        Garage<Bus> garage1 = new Garage<>();
        garage1.setCarOnService(bus); // тип поля carOnService - Bus (не Transport)
        System.out.println(garage1.getCarOnService().isWiFi());

        Garage<Train> garage2 = new Garage<>();
        garage2.setCarOnService(train); // тип поля carOnService - Train (не Transport)
        System.out.println(garage2.getCarOnService().getCarCount());

        Garage<Transport> garage3 = new Garage<>();
        garage3.setCarOnService(bus); // тип поля carOnService - Transport
//        System.out.println(garage3.getCarOnService().isWiFi());
        garage3.setCarOnService(train); // тип поля carOnService - Transport
//        System.out.println(garage3.getCarOnService().getCarCount());
    }
}
