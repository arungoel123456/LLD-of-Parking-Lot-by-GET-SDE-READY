package com.demo.interfaces;

import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;

public interface ParkingSpotService {
    ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor);
}
