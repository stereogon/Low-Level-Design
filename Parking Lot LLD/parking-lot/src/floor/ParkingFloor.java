package floor;

import util.Distributor;
import vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();
    private List<Panel> entryPanels = new ArrayList<>();
    private List<Panel> exitPanels = new ArrayList<>();
    private int floorNumber;

    public ParkingFloor(int totalEntryPanels, int totalExitPanels, int floorNumber, Distributor<VehicleType> parkingDistributor) {
        if (totalExitPanels <= 0 || totalEntryPanels <= 0) {
            throw new RuntimeException("illegal arguments");
        }

        this.floorNumber = floorNumber;

        int it = 0;
        for (VehicleType vehicleType : VehicleType.values()) {
            int count = parkingDistributor.getCount(vehicleType);
            for (it = 0; it < count; it++) {
                parkingSpots.add(new ParkingSpot(it + 1, floorNumber, vehicleType));
            }
        }

        for (int i=0; i<totalEntryPanels; i++) {
            entryPanels.add(new Panel());
        }

        for (int i=0; i<totalExitPanels; i++) {
            exitPanels.add(new Panel());
        }
    }

    public List<Panel> getEntryPanels() {
        return entryPanels;
    }

    public void setEntryPanels(List<Panel> entryPanels) {
        this.entryPanels = entryPanels;
    }

    public List<Panel> getExitPanels() {
        return exitPanels;
    }

    public void setExitPanels(List<Panel> exitPanels) {
        this.exitPanels = exitPanels;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ParkingSpot getFirstEmptySpot(VehicleType vehicleType) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getVehicleType().equals(vehicleType)) {
                return spot;
            }
        }

        return null;
    }
}
