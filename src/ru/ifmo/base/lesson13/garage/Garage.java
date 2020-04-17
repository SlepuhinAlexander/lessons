package ru.ifmo.base.lesson13.garage;
// если в качестве типа мы укажем дженерик без ограничений <T>,
// тип данных carOnService может быть любым (в гараж может заехать любой объект)
// в такой ситуации для carOnService будут доступны только методы Object

// если в качестве дженерик мы укажем <T extends Transport>,
// то тип данных carOnService может Transport и любой из его потомков
// в такой ситуации для carOnService будут доступны только методы Transport

// если в качестве дженерик мы укажем <T extends Bus>,
// то тип данных carOnService может Bus и любой из его потомков
// в такой ситуации для carOnService будут доступны только методы Bus

// если в качестве дженерик мы укажем <T extends Transport & Repairing>,
// то тип данных carOnService может Transport и любой из его потомков +
// + от должен реализовывать интерфейс Repairing

// можно ограничить интерфейсом (интерфейсами) <T extends Repairing & Cloneable>
public class Garage<T extends Transport & Repairing> {
//public class Garage<T extends Transport & Repairing, K> {
    private T carOnService;
//    private K secondCarOnService; // тип данных K может быть любым!!!
    // для secondCarOnService будут доступны только методы Object

    public T getCarOnService() {
        return carOnService;
    }

    public void setCarOnService(T carOnService) {
        this.carOnService = carOnService;
    }

    public void service(){
        carOnService.repair();
    }
}

// маршрутное такси наследуется от Bus + реализует интерфейс someInterf
// garage может принимать только автобусы и их потомков, которые
// реализуют someInterf
