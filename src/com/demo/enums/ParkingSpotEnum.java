package com.demo.enums;

import com.demo.dto.parkingSpot.*;

public enum ParkingSpotEnum {

    COMPACT(Compact.class),
    MINI(Mini.class),
    LARGE(Large.class);

    private Class parkingSpot;

    ParkingSpotEnum(Class parkingSpot){
        this.parkingSpot= parkingSpot;
    }

    public Class getParkingSpot(){
        return parkingSpot;
    }

}
