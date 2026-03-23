import java.util.*;

class Level {
    int floorNumber;
    List<ParkingSpot> spots;

    public Level(int floor) {
        this.floorNumber = floor;
        this.spots = new ArrayList<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}