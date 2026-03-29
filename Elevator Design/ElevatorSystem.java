import java.util.*;

public class ElevatorSystem {
    public static void main(String[] args) {

        List<Lift> lifts = Arrays.asList(
                new Lift(1, 500),
                new Lift(2, 600)
        );

        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            floors.add(new Floor(i));
        }

        SelectionStrategy selectionStrategy = new Nearest();
        MovementStrategy movementStrategy = new Priority();

        LiftService service = new LiftService(
                lifts,
                floors,
                selectionStrategy,
                movementStrategy
        );

        service.requestLift(5);
        service.requestLift(2);
    }
}