import java.time.Duration;
import java.time.LocalDateTime;

class Ticket {
    String ticketId;
    Vehicle vehicle;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    ParkingSpot spot;
    int entryGate;

    public Ticket(String id, Vehicle vehicle, ParkingSpot spot, int gate) {
        this.ticketId = id;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryGate = gate;
        this.entryTime = LocalDateTime.now();
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
    }

    public long calculateParkingDuration() {
        return Duration.between(entryTime, exitTime).toHours();
    }
}