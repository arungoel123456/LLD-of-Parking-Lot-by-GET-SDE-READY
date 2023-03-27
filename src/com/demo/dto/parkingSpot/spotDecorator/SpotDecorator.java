package com.demo.dto.parkingSpot.spotDecorator;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;

public abstract class SpotDecorator extends ParkingSpot {
    protected ParkingSpot parkingSpot;

    public SpotDecorator(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
