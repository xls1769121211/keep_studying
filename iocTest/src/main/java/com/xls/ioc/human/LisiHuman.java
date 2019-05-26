package com.xls.ioc.human;

import com.xls.ioc.car.Car;

public class LisiHuman extends HumanWithCar {
    public LisiHuman(Car car) {
        super(car);
    }

    public void goHome() {
        car.start();
        car.stop();
    }
}
