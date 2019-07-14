package com.teja.parkinglot.impl;

import com.teja.parkinglot.interfaces.Vehicle;
import com.teja.parkinglot.interfaces.VehicleType;

public class Car implements Vehicle {
    String color;

    String registration;
    VehicleType vehicleType;

    public Car(String color, String registration, VehicleType vehicleType) {
        this.color = color;
        this.registration = registration;
        this.vehicleType = vehicleType;
    }


    @Override
    public String getColour() {
        return color;
    }

    @Override
    public String getRegNum() {
        return registration;
    }

    @Override
    public VehicleType getVehicleType() {
        return null;
    }
}
