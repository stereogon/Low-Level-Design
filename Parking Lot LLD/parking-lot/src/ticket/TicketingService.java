package ticket;

import floor.ParkingSpot;
import vehicle.Vehicle;

import java.time.Instant;

public class TicketingService {
    public static Ticket generateTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
        return new Ticket(parkingSpot, vehicle);
    }

    public static double calculateParkingCharge(Ticket ticket) {
        Instant now = Instant.now();
        long secondsSpent = now.getEpochSecond() - ticket.getCheckInTime().getEpochSecond();
        double hours = (double) secondsSpent / (60 * 60);
        return hours * ticket.getHourlyRate();
    }
}
