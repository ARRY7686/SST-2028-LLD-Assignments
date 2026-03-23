abstract class ParkingSpot {
    int spotNumber;
    Vehicle vehicle;
    double hourlyRate;

    public ParkingSpot(int spotNumber, double rate) {
        this.spotNumber = spotNumber;
        this.hourlyRate = rate;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void vacate() {
        this.vehicle = null;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}

class SmallSpot extends ParkingSpot {
    public SmallSpot(int num) {
        super(num, 10);
    }
}

class MediumSpot extends ParkingSpot {
    public MediumSpot(int num) {
        super(num, 20);
    }
}

class LargeSpot extends ParkingSpot {
    public LargeSpot(int num) {
        super(num, 30);
    }
}