package ticket;

import floor.ParkingSpot;
import vehicle.Vehicle;
import vehicle.VehicleType;

import java.time.Instant;

public class Ticket {
    private int parkingSpotNumber;
    private int parkingSpotFloor;
    private String vehicleLicensePlate;
    private VehicleType vehicleType;
    private Instant checkInTime;
    private double hourlyRate;

    Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.parkingSpotNumber = parkingSpot.getSpotNumber();
        this.parkingSpotFloor = parkingSpot.getFloor();
        this.vehicleLicensePlate = vehicle.getLicensePlate();
        this.vehicleType = vehicle.getVehicleType();
        this.checkInTime = Instant.now();
        this.hourlyRate = 0.0; // TODO
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public int getParkingSpotFloor() {
        return parkingSpotFloor;
    }

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Instant getCheckInTime() {
        return checkInTime;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
