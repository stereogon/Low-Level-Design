package floor;

import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private VehicleType vehicleType;
    private boolean isOccupied;
    private Vehicle vehicle;
    private int floor;

    public ParkingSpot(int spotNumber, int floor, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.floor = floor;
        isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setVehicle(Vehicle vehicle) {
        if (isOccupied) throw new RuntimeException("parking spot already occupied");

        if (!vehicle.getVehicleType().equals(this.vehicleType)) {
            throw new RuntimeException("not a valid parking spot for vehicle type: " + vehicleType.toString());
        }

        isOccupied = true;
        this.vehicle = vehicle;
    }

    public Vehicle vacateSpot() {
        if (!isOccupied) throw new RuntimeException("parking spot already empty");

        isOccupied = false;
        Vehicle vehicleVacated = this.vehicle;
        this.vehicle = null;
        return vehicleVacated;
    }
}
