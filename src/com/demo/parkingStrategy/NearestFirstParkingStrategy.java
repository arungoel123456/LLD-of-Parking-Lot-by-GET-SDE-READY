package com.demo.parkingStrategy;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;
import com.demo.exceptions.*;

import java.util.*;

public class NearestFirstParkingStrategy implements Strategy{
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {

        List<ParkingSpot> parkingSpots= ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if(parkingSpots.size()==0){
            throw new SpotNotFoundException("Spot not found in nearest first strategy");
        }
        return parkingSpots.get(0);
    }
}
