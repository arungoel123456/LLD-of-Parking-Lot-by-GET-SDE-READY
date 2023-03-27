package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.parkingSpot.spotDecorator.*;
import com.demo.dto.vehicle.*;
import com.demo.enums.*;
import com.demo.exceptions.*;
import com.demo.interfaces.*;
import com.demo.interfaces.Observer;
import com.demo.parkingStrategy.*;

import java.util.*;

public class ParkingServiceImpl implements ParkingService {

    Strategy parkingStrategy;
    ParkingLot parkingLot;
    DisplayService displayService;
    private List<Observer> observers;

    public ParkingServiceImpl(Strategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        parkingLot= ParkingLot.getInstance();
        displayService= new DisplayServiceImpl();
        observers= new ArrayList<>();
    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingSpotEnum parkingSpotEnum= vehicle.getParkingSpotEnum();
        List<ParkingSpot> freeParkingSpots= parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
        List<ParkingSpot> occupiedParkingSpots= parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);


        try {
            ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum);

            if(parkingSpot.isFree()){
                synchronized (parkingSpot){
                    if(parkingSpot.isFree()){
                        parkingSpot.setFree(false);
                        freeParkingSpots.remove(parkingSpot);
                        occupiedParkingSpots.add(parkingSpot);
                        ParkingTicket parkingTicket= new ParkingTicket(vehicle, parkingSpot);

                        ParkingEvent parkingEvent= new ParkingEvent(ParkingEventType.EnTRY, parkingSpotEnum);
                        notifyAllObservers(parkingEvent);
                        return parkingTicket;
                    }
                    entry(vehicle);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;

    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(ParkingEvent parkingEvent){
        for(Observer observer: observers){
            observer.update(parkingEvent);
        }
    }

    private void addParkingSpotInFreeList( List<ParkingSpot> parkingSpots, ParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
    }

    public  void addWash(ParkingTicket parkingTicket){
        parkingTicket.setParkingSpot( new Wash( parkingTicket.getParkingSpot()));
        return;
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
        if(parkingTicket.getVehicle().equals(vehicle)){
            ParkingSpot parkingSpot= parkingTicket.getParkingSpot();
            int amount= parkingSpot.getAmount();
            parkingSpot.setFree(true);
            parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotEnum()).remove(parkingSpot);
            addParkingSpotInFreeList(parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotEnum()) , parkingSpot);

            ParkingEvent parkingEvent= new ParkingEvent(ParkingEventType.EXIT, vehicle.getParkingSpotEnum());
            notifyAllObservers(parkingEvent);
            return amount;
        }
        else {
            throw  new InvalidTicketException("This is an invalid ticket");
        }

    }
}
