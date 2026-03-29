import java.util.*;
class Nearest implements SelectionStrategy {
    @Override
    public Lift selectNext(List<Lift> lifts, int requestedFloor) {
        Lift best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            int dist = Math.abs(lift.currFloor - requestedFloor);
            if (dist < minDistance) {
                minDistance = dist;
                best = lift;
            }
        }
        return best;
    }
}