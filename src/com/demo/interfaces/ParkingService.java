package com.demo.interfaces;

import com.demo.dto.*;
import com.demo.dto.vehicle.*;
import com.demo.exceptions.*;

public interface ParkingService {
    ParkingTicket entry(Vehicle vehicle);
    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
