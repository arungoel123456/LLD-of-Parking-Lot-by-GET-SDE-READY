package com.demo.dto;

import com.demo.enums.*;

import java.util.*;

public class DisplayBoard {

    private static DisplayBoard displayBoard= null;
    private Map<ParkingSpotEnum, Integer> freeParkingSpots;

    private DisplayBoard() {
        this.freeParkingSpots = new HashMap<>();
    }

    public static DisplayBoard getInstance(){
        if(displayBoard== null){
            displayBoard= new DisplayBoard();
        }
        return displayBoard;
    }

    public Map<ParkingSpotEnum, Integer> getFreeParkingSpots() {
        return freeParkingSpots;
    }

}
