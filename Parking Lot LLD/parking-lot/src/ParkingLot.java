import floor.ParkingFloor;
import floor.ParkingSpot;
import util.Distributor;
import vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<ParkingFloor> floors = new ArrayList<>();

    public ParkingLot(int floorCount) {
        for (int i=0; i<floorCount; i++) {
            floors.add(new ParkingFloor(1, 1, i + 1, new Distributor<>() {
                @Override
                public void initCountMap() {
                    countMap.put(VehicleType.TRUCK, 5);
                    countMap.put(VehicleType.CAR, 10);
                    countMap.put(VehicleType.BIKE, 15);
                }
            }));
        }
    }

    public ParkingSpot getFirstEmptySpot(VehicleType vehicleType) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.getFirstEmptySpot(vehicleType);
            if (spot != null) {
                return spot;
            }
        }

        return null;
    }
}
