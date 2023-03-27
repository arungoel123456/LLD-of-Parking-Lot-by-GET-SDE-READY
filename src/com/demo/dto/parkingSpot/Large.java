package com.demo.dto.parkingSpot;

public class Large extends ParkingSpot{
    public Large(Integer floor) {
        super(floor, 30);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours* amount;
    }
}
