package com.java.ro.ptng.ch10;


/**
 * Created by Bartek on 2015-03-04.
 */
public interface Car {

    Engine getEngine();
    Manufacturer getManufacturer();
    Color getColor();
    boolean isSportCar();
}
