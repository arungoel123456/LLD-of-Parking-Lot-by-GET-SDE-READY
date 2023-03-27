package com.demo.dto.parkingSpot.spotDecorator;

import com.demo.dto.parkingSpot.*;

public class Electric extends SpotDecorator{
    public Electric(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 50;
    }
}
