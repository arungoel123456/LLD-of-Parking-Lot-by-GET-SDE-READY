import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;
import com.demo.enums.*;
import com.demo.exceptions.*;
import com.demo.interfaces.*;
import com.demo.parkingStrategy.*;
import com.demo.services.*;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot=ParkingLot.getInstance();
        ParkingSpotService parkingSpotService= new ParkingSpotServiceImpl();

        ParkingSpot a1= parkingSpotService.create(ParkingSpotEnum.COMPACT, 0);
        ParkingSpot a2= parkingSpotService.create(ParkingSpotEnum.COMPACT, 0);

        ParkingSpot b1= parkingSpotService.create(ParkingSpotEnum.LARGE, 0);
        ParkingSpot b2= parkingSpotService.create(ParkingSpotEnum.LARGE, 0);

        ParkingSpot c1= parkingSpotService.create(ParkingSpotEnum.MINI, 0);
        ParkingSpot c2= parkingSpotService.create(ParkingSpotEnum.MINI, 0);

        Vehicle v1= new Car();
        Vehicle v2= new Car();
        Vehicle v3= new Car();

        ParkingServiceImpl parkingLotService= new ParkingServiceImpl(new FarthestFirstParkingStrategy());
        PaymentService paymentService= new PaymentServiceImpl();

        ParkingTicket parkingTicket1= parkingLotService.entry(v1);
        System.out.println("parking ticket 1: " +  parkingTicket1);
        System.out.println( "parking ticket 1 with vehicle id: " +  parkingTicket1.getVehicle().getId());
        System.out.println( parkingTicket1.getVehicle().equals(v1) );

        ParkingTicket parkingTicket2= parkingLotService.entry(v2);
        parkingLotService.addWash(parkingTicket2);
        System.out.println("parking ticket 2: " +  parkingTicket2);
        System.out.println( "parking ticket 2 with vehicle id: " +  parkingTicket2.getVehicle().getId());

        try {
            parkingLotService.exit(parkingTicket2, v2);
            int cost = parkingTicket2.getParkingSpot().cost(parkingTicket2.getParkingHours());
            System.out.println("cost: "+ cost);

            paymentService.acceptCash(cost);

        } catch (InvalidTicketException e) {
            throw new RuntimeException(e);
        }


    }
}