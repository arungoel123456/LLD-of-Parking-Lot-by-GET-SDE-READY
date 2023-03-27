package com.demo.interfaces;

import com.demo.dto.*;

public interface Observer {
    void update(ParkingEvent event);
}
