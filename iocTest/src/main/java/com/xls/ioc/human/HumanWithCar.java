package com.xls.ioc.human;

import com.xls.ioc.car.Car;

/**
 * 有车一族
 */
public abstract class HumanWithCar implements Human {
    public Car car;
    public HumanWithCar(Car car) {
        this.car = car;
    }
    public abstract void goHome();
}
