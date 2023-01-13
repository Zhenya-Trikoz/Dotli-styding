package com.tommy.java.basic.carExample;

import com.tommy.java.basic.carExample.details.Engine;
import com.tommy.java.basic.carExample.professions.Driver;
import com.tommy.java.basic.carExample.vehicles.*;

import java.util.ArrayList;
import java.util.List;

public class CarDemo {
    public static void main(String[] args) {
        Driver bmwDriver = new Driver("Иванов В.В.", 50, 30);
        Engine bmwEngine = new Engine("60", "BMW");

        Car car = new Car();
        car.setProducer("BMW");
        car.setaClass("C");
        car.setWeight(5000);
        car.setDriver(bmwDriver);
        car.setEngine(bmwEngine);

        Driver lorryDriver = new Driver("Петров В.В.", 45, 20);
        Engine lorryEngine = new Engine("30", "LorryEngine");
        Lorry lorry = new Lorry("Грузовик", "D", 8000, lorryDriver, lorryEngine, 70);

        Driver sportDriver = new Driver("Сидоров В.В.", 30, 15);
        Engine sportEngine = new Engine("80", "SportEngine");
        SportCar sportCar = new SportCar("SportCar", "C", 4000, sportDriver, sportEngine, 300);

        System.out.println(car);
        System.out.println(lorry);
        System.out.println(sportCar);

        List<Car> listCar = new ArrayList<>();
        listCar.add(car);
        listCar.add(lorry);
        listCar.add(sportCar);

        for (Car car1 : listCar){
            System.out.println(car1.getProducer());
            car1.headlightsOn();
            car1.headlightsOff();

            car1.turnRight();
            car1.turnLeft();

            car1.backlightOn();
            car1.backlightOff();

            car1.trunkOpen();
            car1.trunkClosed();
        }
    }
}