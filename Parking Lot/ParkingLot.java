import java.util.UUID;

class ParkingLot {
    ParkingManager manager;
    FareCalculator fareCalculator;

    public ParkingLot(ParkingManager manager, FareCalculator calculator) {
        this.manager = manager;
        this.fareCalculator = calculator;
    }

    public Ticket park(Vehicle vehicle, int entryGate) {
        ParkingSpot spot = manager.parkVehicle(vehicle);
        if (spot == null) {
            System.out.println("No spot available");
            return null;
        }

        return new Ticket(UUID.randomUUID().toString(), vehicle, spot, entryGate);
    }

    public double exit(Ticket ticket) {
        ticket.closeTicket();
        manager.unparkVehicle(ticket.vehicle);
        return fareCalculator.calculateFare(ticket);
    }
}