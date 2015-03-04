package com.java.ro.ptng.ch10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 2015-03-04.
 */
public class CarSearch {

    private List<Car> cars = new ArrayList<>();

    public void addCard(Car car) {
        cars.add(car);
    }

    public List<Car> findSportCars() {
        List<Car> sportCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSportCar()) {
                sportCars.add(car);
            }
        }
        return sportCars;
    }
}
