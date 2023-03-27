package com.demo.parkingStrategy;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;
import com.demo.exceptions.*;

import java.util.*;

public class FarthestFirstParkingStrategy implements Strategy{
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {
        List<ParkingSpot> parkingSpots= ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if(parkingSpots.size()==0){
            throw new SpotNotFoundException("Spot not found in nearest farthest strategy");
        }
        return parkingSpots.get(parkingSpots.size()-1);
    }
}
