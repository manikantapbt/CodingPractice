package com.teja.parkinglot.impl;

import java.util.List;

public class Lot {
    List<Spot> spots;
    public Spot getFirstSpot(){
        Spot s = new Spot();
        spots.add(s);
        return s;
    }

    public void returning(Spot s){
        spots.remove(s);
    }

}
