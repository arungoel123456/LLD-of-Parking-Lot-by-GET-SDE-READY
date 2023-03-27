package com.demo.services;

import com.demo.dto.*;
import com.demo.enums.*;
import com.demo.interfaces.*;

public class DisplayServiceImpl implements DisplayService , Observer {


    @Override
    public void update(ParkingEvent event) {
        int currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(event.getParkingSpotEnum());
        int change=0;
        if(event.getEventType().equals(ParkingEventType.EnTRY)){
            change=-1;
        }
        else{
            change=1;
        }
        int newCount= currentCount+ change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(event.getParkingSpotEnum(), newCount);
        return;
    }

    public void update(ParkingSpotEnum parkingSpotEnum, int change){
        Integer currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if(currentCount == null)
        {
            currentCount=0;
        }
        int newCount= currentCount+ change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, newCount);

    }
}
