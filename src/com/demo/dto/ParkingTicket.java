package com.demo.dto;

import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;

import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.*;

public class ParkingTicket {
    private static final AtomicInteger x = new AtomicInteger(0);
    private int id;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime timestamp;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        timestamp= LocalDateTime.now();
        id= x.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getParkingHours(){
        return 2;
    }
}
