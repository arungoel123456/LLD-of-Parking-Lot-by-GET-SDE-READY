package com.demo.dto;

import com.demo.enums.*;

public class ParkingEvent {
    private ParkingEventType eventType;
    private ParkingSpotEnum parkingSpotEnum;

    public ParkingEvent(ParkingEventType eventType, ParkingSpotEnum parkingSpotEnum) {
        this.eventType = eventType;
        this.parkingSpotEnum = parkingSpotEnum;
    }

    public ParkingEventType getEventType() {
        return eventType;
    }

    public void setEventType(ParkingEventType eventType) {
        this.eventType = eventType;
    }

    public ParkingSpotEnum getParkingSpotEnum() {
        return parkingSpotEnum;
    }

    public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
        this.parkingSpotEnum = parkingSpotEnum;
    }
}
