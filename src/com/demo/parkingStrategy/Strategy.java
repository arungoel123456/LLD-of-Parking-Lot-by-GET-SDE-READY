package com.demo.parkingStrategy;

import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;
import com.demo.exceptions.*;

public interface Strategy {
    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;
}
