package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;
import com.demo.interfaces.*;

import java.lang.reflect.*;

public class ParkingSpotServiceImpl implements ParkingSpotService {
    DisplayService displayService= new DisplayServiceImpl();

    @Override
    public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor) {
        try {
            ParkingSpot parkingSpot= (ParkingSpot) parkingSpotEnum.getParkingSpot().getConstructor(Integer.class).newInstance(floor);
            ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum).add(parkingSpot);
            displayService.update(parkingSpotEnum,1);
            return parkingSpot;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
