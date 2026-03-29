import java.util.*;
interface SelectionStrategy {
    Lift selectNext(List<Lift> lifts, int requestedFloor);
}