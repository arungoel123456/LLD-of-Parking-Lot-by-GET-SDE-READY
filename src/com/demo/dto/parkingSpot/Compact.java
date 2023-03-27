package com.demo.dto.parkingSpot;

public class Compact extends ParkingSpot{
    public Compact(Integer floor) {
        super(floor, 20);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours* amount;
    }
}
