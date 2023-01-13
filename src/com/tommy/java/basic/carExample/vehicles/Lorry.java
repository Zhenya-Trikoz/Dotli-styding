package com.tommy.java.basic.carExample.vehicles;

import com.tommy.java.basic.carExample.details.Engine;
import com.tommy.java.basic.carExample.professions.Driver;


public class Lorry extends Car {
    private double liftingCapacity;

    public Lorry(String producer, String aClass, double weight, Driver driver, Engine engine, double liftingCapacity) {
        this.setProducer(producer);
        this.setaClass(aClass);
        this.setWeight(weight);
        this.setDriver(driver);
        this.setEngine(engine);
        this.liftingCapacity = liftingCapacity;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(double liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    @Override
    public String toString() {
        return "Lorry{" +
                "liftingCapacity=" + liftingCapacity +
                "} " + super.toString();
    }
}