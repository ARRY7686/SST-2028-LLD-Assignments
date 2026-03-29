import java.util.*;

class Lift {
    int id;
    int currFloor;
    int maxWeight;
    State state;
    Direction direction;

    Queue<Integer> requests;

    public Lift(int id, int maxWeight) {
        this.id = id;
        this.maxWeight = maxWeight;
        this.currFloor = 0;
        this.state = State.IDLE;
        this.direction = Direction.UP;
        this.requests = new LinkedList<>();
    }

    public void addRequest(int floor) {
        requests.offer(floor);
    }

    public void openDoor() {
        System.out.println("Lift " + id + " door opened at floor " + currFloor);
    }

    public void closeDoor() {
        System.out.println("Lift " + id + " door closed");
    }

    public void move() {
        if (requests.isEmpty()) {
            state = State.IDLE;
            return;
        }

        int target = requests.poll();
        state = State.MOVING;

        System.out.println("Lift " + id + " moving from " + currFloor + " to " + target);

        currFloor = target;

        state = State.STOPPED;
        openDoor();
        closeDoor();
    }
}