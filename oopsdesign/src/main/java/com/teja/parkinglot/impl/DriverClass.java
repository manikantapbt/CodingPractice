package com.teja.parkinglot.impl;

import com.teja.parkinglot.interfaces.VehicleType;

public class DriverClass {

    public static void main(String[] args) {
        Lot lot = new Lot();
        Car c = new Car("Red","", VehicleType.SEMITRUCK);
        Spot s =lot.getFirstSpot();
        s.spotCar(c);


    }
}
