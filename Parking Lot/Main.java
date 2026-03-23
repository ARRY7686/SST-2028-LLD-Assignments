import java.util.*;
public class Main {
    public static void main(String[] args) {

        Level level1 = new Level(1);
        level1.addSpot(new SmallSpot(1));
        level1.addSpot(new MediumSpot(2));
        level1.addSpot(new LargeSpot(3));

        ParkingManager manager = new ParkingManager(List.of(level1));
        FareCalculator calculator = new FareCalculator(new DefaultFareStrategy());

        ParkingLot lot = new ParkingLot(manager, calculator);

        Vehicle car = new Car("KA01AB1234");

        Ticket ticket = lot.park(car, 1);

        try { Thread.sleep(2000); } catch (Exception e) {}

        double fare = lot.exit(ticket);

        System.out.println("Fare: " + fare);
    }
}