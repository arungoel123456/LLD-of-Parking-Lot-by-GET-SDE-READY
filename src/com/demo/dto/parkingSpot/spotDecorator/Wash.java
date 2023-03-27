package com.demo.dto.parkingSpot.spotDecorator;

import com.demo.dto.parkingSpot.*;

public class Wash extends  SpotDecorator{

    public Wash(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }
    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 20;
    }
}
