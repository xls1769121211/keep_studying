package com.xls.ioc.human;

import com.xls.ioc.car.Car;

public class ZhanSan extends HumanWithCar{
    public ZhanSan(Car car) {
        super(car);
    }
    public void goHome() {
        car.start();
        car.turnLeft();
        car.stop();
    }
}
