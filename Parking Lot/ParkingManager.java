import java.util.*;

class ParkingManager {

    Map<VehicleEnum, List<ParkingSpot>> availableSpots = new HashMap<>();
    Map<Vehicle, ParkingSpot> vehicleSpotMap = new HashMap<>();

    public ParkingManager(List<Level> levels) {
        for (Level level : levels) {
            for (ParkingSpot spot : level.getSpots()) {
                availableSpots
                    .computeIfAbsent(getType(spot), k -> new ArrayList<>())
                    .add(spot);
            }
        }
    }

    private VehicleEnum getType(ParkingSpot spot) {
        if (spot instanceof SmallSpot) return VehicleEnum.TWO_WHEELER;
        if (spot instanceof MediumSpot) return VehicleEnum.CAR;
        return VehicleEnum.BUS;
    }

    public ParkingSpot findSpot(Vehicle vehicle) {
        List<ParkingSpot> spots = availableSpots.get(vehicle.getVehicleType());
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) return spot;
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findSpot(vehicle);
        if (spot != null) {
            spot.occupy(vehicle);
            vehicleSpotMap.put(vehicle, spot);
        }
        return spot;
    }

    public void unparkVehicle(Vehicle vehicle) {
        ParkingSpot spot = vehicleSpotMap.get(vehicle);
        if (spot != null) {
            spot.vacate();
            vehicleSpotMap.remove(vehicle);
        }
    }
}