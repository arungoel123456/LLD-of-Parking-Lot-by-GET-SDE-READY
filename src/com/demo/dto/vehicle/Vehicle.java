package com.demo.dto.vehicle;

import com.demo.enums.*;

import java.util.concurrent.atomic.*;

public abstract class Vehicle {
    private static final AtomicInteger x = new AtomicInteger(0);
    private int id;
    private ParkingSpotEnum parkingSpotEnum;

    public Vehicle(ParkingSpotEnum parkingSpotEnum) {
        this.parkingSpotEnum = parkingSpotEnum;
        id= x.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpotEnum getParkingSpotEnum() {
        return parkingSpotEnum;
    }

    public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
        this.parkingSpotEnum = parkingSpotEnum;
    }
}
