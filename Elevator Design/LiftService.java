import java.util.*;

class LiftService {
    List<Lift> lifts;
    List<Floor> floors;

    SelectionStrategy selectionStrategy;
    MovementStrategy movementStrategy;

    public LiftService(List<Lift> lifts, List<Floor> floors,
                       SelectionStrategy selectionStrategy,
                       MovementStrategy movementStrategy) {
        this.lifts = lifts;
        this.floors = floors;
        this.selectionStrategy = selectionStrategy;
        this.movementStrategy = movementStrategy;
    }

    public void requestLift(int floorNumber) {
        Lift lift = selectionStrategy.selectNext(lifts, floorNumber);

        if (lift != null) {
            System.out.println("Assigning Lift " + lift.id + " to floor " + floorNumber);
            lift.addRequest(floorNumber);
            lift.move();
        }
    }

    public void pushButton(Lift lift, int destinationFloor) {
        lift.addRequest(destinationFloor);
    }
}